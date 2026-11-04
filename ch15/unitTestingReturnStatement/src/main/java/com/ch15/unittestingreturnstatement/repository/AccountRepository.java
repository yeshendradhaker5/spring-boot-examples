package com.ch15.unittestingreturnstatement.repository;

import com.ch15.unittestingreturnstatement.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
