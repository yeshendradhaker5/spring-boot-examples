package com.ch13.transactioncommit.repository;

import com.ch13.transactioncommit.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;
    private Logger logger = Logger.getLogger(AccountRepository.class.getName());

    public AccountRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account getAccountById(Long accountId){
        String sql = "select * from account where id= ?";

        RowMapper<Account> accountRowMapper = (r, i) -> {
            Account account = new Account();
            account.setId(r.getLong("id"));
            account.setName(r.getString("name"));
            account.setBalance(r.getBigDecimal("balance"));

            return account;
        };

        Account account = jdbcTemplate.queryForObject(sql, accountRowMapper, accountId);
        logger.info("Account object "+account);
        logger.info("Account info "+account.getName());
        return account;
    }

    public void updateAmount(Long id, BigDecimal amount){
        String sql = "update account set balance = ? where id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    public List<Account> getAllAccounts(){
        String sql = "select * from account";

        RowMapper<Account> rowMapper = (r, i) -> {
            Account account = new Account();
            account.setId(r.getLong("id"));
            account.setName(r.getString("name"));
            account.setBalance(r.getBigDecimal("balance"));

            return account;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }
}
