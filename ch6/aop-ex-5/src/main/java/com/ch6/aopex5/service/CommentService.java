package com.ch6.aopex5.service;

import com.ch6.aopex5.custom.SecurityCheck;
import com.ch6.aopex5.custom.ToLog;
import com.ch6.aopex5.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    @SecurityCheck
    public String publishComment(Comment comment){
        logger.info("Comment Published");
        return "SUCCESS";
    }

}
