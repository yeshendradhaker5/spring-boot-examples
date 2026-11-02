package com.ch4.spring_context_interface_ex1.proxies.proxiesImpl;

import com.ch4.spring_context_interface_ex1.model.Comment;
import com.ch4.spring_context_interface_ex1.proxies.NotifyUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class PushNotification implements NotifyUser {

    @Override
    public void notificationSent(Comment comment) {
        System.out.println("Notification sent via Push Notification: Comment: "+comment.getCommentText());
    }
}
