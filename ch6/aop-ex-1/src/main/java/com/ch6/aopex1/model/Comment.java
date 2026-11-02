package com.ch6.aopex1.model;

public class Comment {

    private String text;

    private String authorName;

    public Comment(String text, String authorName){
        this.text = text;
        this.authorName = authorName;
    }

    public String getText() {
        return text;
    }

    public String getAuthorName() {
        return authorName;
    }
}
