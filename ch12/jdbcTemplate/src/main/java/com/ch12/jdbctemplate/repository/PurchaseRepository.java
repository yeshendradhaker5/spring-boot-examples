package com.ch12.jdbctemplate.repository;

import com.ch12.jdbctemplate.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addPurchase(Purchase purchase){
        String sql = "INSERT INTO purchase VALUES(DEFAULT, ?, ?)";

        jdbcTemplate.update(sql,
                purchase.getProductName(),
                purchase.getPrice());
    }

    public List<Purchase> findAllPurchases(){
        String sql = "SELECT * from purchase";
        RowMapper<Purchase> rowMapper = (r,i)->{
            Purchase purchase = new Purchase();
            purchase.setId(r.getLong("id"));
            purchase.setProductName(r.getString("name"));
            purchase.setPrice(r.getBigDecimal("price"));

            return purchase;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }

}
