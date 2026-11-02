package com.ch4.spring_context_interface_ex1.repository.repositoriyImpl;

import com.ch4.spring_context_interface_ex1.model.Comment;
import com.ch4.spring_context_interface_ex1.repository.StoreComments;
import org.springframework.stereotype.Repository;

@Repository
public class DBStoreComment implements StoreComments {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Comment Stored");
    }
}
