package com.ch5.beanscope4.service;


import com.ch5.beanscope4.repository.DBRepository;

public class CommentService {

    private final DBRepository dbRepository;

    public CommentService(DBRepository dbRepository){
        this.dbRepository = dbRepository;
    }

    public DBRepository getDbRepository(){
        return this.dbRepository;
    }

}
