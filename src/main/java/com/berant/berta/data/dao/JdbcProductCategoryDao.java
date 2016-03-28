package com.berant.berta.data.dao;
/*
import com.berant.berta.data.Category;
import com.berant.berta.data.dto.ProductCategoryDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository("productCategoryDao")
public class JdbcProductCategoryDao implements CategoryDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Category find(int id) {
        try {
            return find(null, id, null);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private Category find(Category childCategory, int id, Category returnProductCategory) {
        String sql = "SELECT * from Category where id = :categoryId";
        SqlParameterSource namedParameters = new MapSqlParameterSource("categoryId", id);
        ProductCategoryDto productCategoryDto = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new ProductCategoryDtoMapper());
        Category productCategory = new Category();
        productCategory.setId(productCategoryDto.getId());
        productCategory.setName(productCategoryDto.getName());
        productCategory.setDescription(productCategoryDto.getDescription());
        if (childCategory != null) {
            childCategory.setParentCategory(productCategory);
        }
        if (returnProductCategory == null) {
            returnProductCategory = productCategory;
        }
        if (productCategoryDto.getParentId() <= 0) {
            productCategory.setParentCategory(null);
            return returnProductCategory;
        } else {
            return find(productCategory, productCategoryDto.getParentId(), returnProductCategory);
        }
    }

    @Override
    public List<Category> findAllRoot() {
        return null;
    }

    @Override
    public void insert(Category productCategory) {
        Integer parentId = null;
        if (productCategory.getParentCategory() != null) {
            parentId = productCategory.getParentCategory().getId();
            Category parentProductCategory = find(parentId);
            if (parentProductCategory == null) {
                throw new RuntimeException("No parent Category with id = " + parentId);
            }
        }
        String sql = "INSERT INTO Category (parent_id, name, description) VALUES (:parent_id, :name, :description)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", productCategory.getName());
        namedParameters.addValue("description", productCategory.getDescription());
        namedParameters.addValue("parent_id", parentId);
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    @Override
    public void update(Category productCategory) {

    }

    @Override
    public void delete(int id) {

    }

    private static final class ProductCategoryDtoMapper implements RowMapper<ProductCategoryDto> {
        public ProductCategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProductCategoryDto dto = new ProductCategoryDto();
            dto.setId(rs.getInt("id"));
            dto.setName(rs.getString("name"));
            dto.setDescription(rs.getString("description"));
            dto.setParentId(rs.getInt("parent_id"));
            return dto;
        }
    }
}
*/