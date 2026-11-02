package com.ch12.jdbctemplatemysqldatasource.repository;

import com.ch12.jdbctemplatemysqldatasource.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProduct(Product product){
        String sql = "INSERT INTO product values(DEFAULT, ?, ?)";

        jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

    public List<Product> getAllProducts(){
        String sql = "select * from product";

        RowMapper<Product> rowMapper = (r, i) -> {
            Product product = new Product();
            product.setId(r.getLong("id"));
            product.setName(r.getString("productname"));
            product.setPrice(r.getBigDecimal("price"));

            return product;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }
}
