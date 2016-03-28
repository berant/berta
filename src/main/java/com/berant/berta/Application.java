package com.berant.berta;

import com.berant.berta.data.dao.ProductDao;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.GenericXmlApplicationContext;


//@ImportResource({"classpath:applicationContext.xml"})
public class Application {

    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:applicationContext.xml");
        context.refresh();

        ProductDao productDao = context.getBean("productDao", ProductDao.class);
        System.out.println(productDao.findAll());
    }
}
