package com.ch4.spring_context_interface_ex1.proxies.proxiesImpl;

import com.ch4.spring_context_interface_ex1.model.Comment;
import com.ch4.spring_context_interface_ex1.proxies.NotifyUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("push")
public class EmailNotification implements NotifyUser {

    @Override
    public void notificationSent(Comment comment) {
        System.out.println("Notification sent: Comment "+comment.getCommentText());
    }
}
