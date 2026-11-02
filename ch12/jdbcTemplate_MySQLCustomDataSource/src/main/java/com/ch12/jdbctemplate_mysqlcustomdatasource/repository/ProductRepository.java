package com.ch12.jdbctemplate_mysqlcustomdatasource.repository;

import com.ch12.jdbctemplate_mysqlcustomdatasource.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate mysqlJdbcTemplate;
    private final JdbcTemplate postgresqlJdbcTemplate;

    public ProductRepository(@Qualifier("mysqlJdbcTemplate") JdbcTemplate mysqlJdbcTemplate,
                             @Qualifier("postgresqlJdbcTemplate") JdbcTemplate postgresqlJdbcTemplate){
        this.mysqlJdbcTemplate = mysqlJdbcTemplate;
        this.postgresqlJdbcTemplate = postgresqlJdbcTemplate;
    }

    public void addProduct(Product product){
        String sql = "insert into product (name, price) values (?, ?)";

        mysqlJdbcTemplate.update(sql, product.getName(), product.getPrice());
        postgresqlJdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

//    public List<Product> getAllProducts(){
//        String sql = "select * from product";
//
//        RowMapper<Product> rowMapper = (r, i)->{
//            Product product = new Product();
//            product.setId(r.getLong("id"));
//            product.setName(r.getString("name"));
//            product.setPrice(r.getBigDecimal("price"));
//
//            return product;
//        };
//
//        return jdbcTemplate.query(sql, rowMapper);
//    }
}
