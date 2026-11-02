package com.ch6.aopex3.service;

import com.ch6.aopex3.custom.ToLog;
import com.ch6.aopex3.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment){
        logger.info("Comment published");
        return "SUCCESS";
    }

    @ToLog
    public String deleteComment(Comment comment){
        logger.info("Comment Deleted");
        return "SUCCESS";
    }

    public String editComment(Comment comment){
        logger.info("Comment Edited");
        return "SUCCESS";
    }
}
