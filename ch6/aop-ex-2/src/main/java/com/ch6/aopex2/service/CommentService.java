package com.ch6.aopex2.service;

import com.ch6.aopex2.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment){
        logger.info("Comment Published");
        return "SUCCESS";
    }

}
