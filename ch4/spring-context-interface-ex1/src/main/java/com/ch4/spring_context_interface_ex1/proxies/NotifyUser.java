package com.ch4.spring_context_interface_ex1.proxies;

import com.ch4.spring_context_interface_ex1.model.Comment;

public interface NotifyUser {

    void notificationSent(Comment comment);
}
