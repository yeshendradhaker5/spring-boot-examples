package com.ch6.aopex4.service;

import com.ch6.aopex4.custom.ToLog;
import com.ch6.aopex4.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment){
        logger.info("Comment Published");
        return "SUCCESS";
    }
}
