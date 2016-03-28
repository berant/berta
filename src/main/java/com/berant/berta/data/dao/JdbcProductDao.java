package com.berant.berta.data.dao;

import com.berant.berta.data.Category;
import com.berant.berta.data.Product;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository("productDao")
public class JdbcProductDao implements ProductDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
    private InsertProduct insertProduct;

    private static final String ALL_FIELDS = "Product.id, Product.name, Product.description, Product.price_buy, Category.id, Category.name";
    private static final String SELECT_ALL = "SELECT " + ALL_FIELDS + " FROM Product LEFT JOIN Category ON Product.category_id = Category.id";

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertProduct = new InsertProduct(dataSource);
    }


    @Override
    public List<Product> findAll() {
        String sql = SELECT_ALL;
        List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
        return products;
    }

    @Override
    public Product find(int id) {
        String sql = SELECT_ALL + " WHERE Product.id = :productId";
        SqlParameterSource namedParameters = new MapSqlParameterSource("productId", id);
        Product product = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new ProductMapper());
        return product;
    }

    @Override
    public int insert(Product product) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", product.getName());
        params.put("description", product.getDescription());
        params.put("categoryId", product.getCategory().getId());
        params.put("priceBuy", product.getPriceBuy());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertProduct.updateByNamedParam(params, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void update(Product product) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Product WHERE id = :productId";
        SqlParameterSource namedParamters = new MapSqlParameterSource("productId", id);
        namedParameterJdbcTemplate.update(sql, namedParamters);
    }

    private static final class ProductMapper implements RowMapper<Product> {
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getInt("Product.id"));
            product.setName(rs.getString("Product.name"));
            product.setDescription(rs.getString("Product.description"));
            product.setPriceBuy(rs.getDouble("Product.price_buy"));
            Category category = new Category();
            category.setId(rs.getInt("Category.id"));
            category.setName(rs.getString("Category.name"));
            product.setCategory(category);
            return product;
        }
    }

    private static class InsertProduct extends SqlUpdate {
        private static final String SQL_INSERT_PRODUCT = "INSERT INTO Product (name, description, category_id, price_buy) VALUES (:name, :description, :categoryId, :priceBuy)";

        public InsertProduct(DataSource dataSource) {
            super(dataSource, SQL_INSERT_PRODUCT);
            declareParameter(new SqlParameter("name", Types.VARCHAR));
            declareParameter(new SqlParameter("description", Types.VARCHAR));
            declareParameter(new SqlParameter("categoryId", Types.INTEGER));
            declareParameter(new SqlParameter("priceBuy", Types.DOUBLE));
            setGeneratedKeysColumnNames(new String[] {"id"});
            setReturnGeneratedKeys(true);
        }
    }
}
