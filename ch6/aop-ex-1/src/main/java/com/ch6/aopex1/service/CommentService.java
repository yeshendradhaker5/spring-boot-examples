package com.ch6.aopex1.service;

import com.ch6.aopex1.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment){
        logger.info("Comment Published");
    }

    public void processComment(Comment comment){
        logger.info("Comment Processed");
    }

}
