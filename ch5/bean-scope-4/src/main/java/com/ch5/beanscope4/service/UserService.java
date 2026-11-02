package com.ch5.beanscope4.service;

import com.ch5.beanscope4.repository.DBRepository;

public class UserService {

    private final DBRepository dbRepository;

    public UserService(DBRepository dbRepository){
        this.dbRepository = dbRepository;
    }

    public DBRepository getDbRepository(){
        return this.dbRepository;
    }
}
