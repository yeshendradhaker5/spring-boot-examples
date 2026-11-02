package com.ch4.spring_context_interface_ex1.model;


public class Comment {
    private final String commentText;

    public Comment(String commentText){
        this.commentText = commentText;
    }

    public String getCommentText(){
        return this.commentText;
    }

}
