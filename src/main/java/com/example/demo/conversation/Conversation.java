package com.example.demo.conversation;

import java.time.LocalDate;

public class Conversation {
    
    private Long id;
    private String title;
    private String sentence;
    private String paragraph;
    private LocalDate edited;
    private String permission;

    public Conversation() {}

    public Conversation( Long id,
                        String title,
                        String sentence,
                        String paragraph,
                        LocalDate edited,
                        String permission
    ) {
        this.id = id;
        this.title = title;
        this.sentence = sentence;
        this.paragraph = paragraph;
        this.edited = edited;
        this.permission = permission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

     public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public LocalDate getEdited() {
        return edited;
    }

    public void setEdited(LocalDate edited) {
        this.edited = edited;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}