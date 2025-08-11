package com.example.demo.conversation;

import java.time.LocalDate;

/* Transforms the Conversation into a Data Object */

public class ConversationDTO {
    private Long id;
    private String title;
    private String sentence;
    private LocalDate edited;
    private String permission;


    public ConversationDTO() {}

    public ConversationDTO( Long id,
                        String title,
                        String sentence,
                        LocalDate edited,
                        String permission
    ) {
        this.id = id;
        this.title = title;
        this.sentence = sentence;
        this.edited = edited;
        this.permission = permission;
    }

    public static ConversationDTO fromConversation(Conversation conversation) {
            return new ConversationDTO( 
                conversation.getId(), 
                conversation.getTitle(),
                conversation.getSentence(),
                conversation.getEdited(),
                conversation.getPermission()
        );
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
