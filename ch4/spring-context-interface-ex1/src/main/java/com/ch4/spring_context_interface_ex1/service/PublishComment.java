package com.ch4.spring_context_interface_ex1.service;

import com.ch4.spring_context_interface_ex1.model.Comment;
import com.ch4.spring_context_interface_ex1.proxies.NotifyUser;
import com.ch4.spring_context_interface_ex1.repository.StoreComments;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PublishComment {

    private final NotifyUser notifyUser;
    private final StoreComments storeComments;

    public PublishComment(@Qualifier("push") NotifyUser notifyUser, StoreComments storeComments){
        this.notifyUser = notifyUser;
        this.storeComments = storeComments;
    }

    public void publishComment(Comment comment){
        notifyUser.notificationSent(comment);
        storeComments.storeComment(comment);
    }
}
