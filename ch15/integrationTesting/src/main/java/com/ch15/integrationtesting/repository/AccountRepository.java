package com.ch15.integrationtesting.repository;

import com.ch15.integrationtesting.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    @Modifying
    @Query("update account set balance=:amount where id=:id")
    public void updateAmount(Long id, BigDecimal amount);

    @Query("select * from account where name=:name")
    public List<Account> getAccountsByName(String name);
}
