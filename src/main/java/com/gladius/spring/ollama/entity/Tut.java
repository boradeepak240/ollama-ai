package com.gladius.spring.ollama.entity;

public class Tut {
    String title;
    String content;
    String createdYear;

    public Tut() {
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Tut(String title, String content, String createdYear) {
        this.title = title;
        this.content = content;
        this.createdYear = createdYear;
    }
    public String getCreatedYear() {
        return createdYear;
    }
    public void setCreatedYear(String createdYear) {
        this.createdYear = createdYear;
    }
    
}
