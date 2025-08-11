package com.example.demo.conversation;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class Controller {
 
    // final variable can only be assigned once
    private final ConversationService service;

    public Controller(ConversationService service) {
        this.service = service;
    }

    @GetMapping
    public String getService() {
        return "conversation service";
    }

    @GetMapping(path = "user/all")
    public List<ConversationDTO> getUserConversations() {
        return service.getConversations("USER");
    }

    @GetMapping(path = "admin/all")
    public List<ConversationDTO> getAdminConversations() {
        return service.getConversations("ADMIN");
    }

    @GetMapping(path = "user/{id}")
    public Conversation getUserConversation(@PathVariable("id") Long id) {
        return service.getConversation(id, "USER");
    }

    @GetMapping(path = "admin/{id}")
    public Conversation getAdminConversation(@PathVariable("id") Long id) {
        return service.getConversation(id, "ADMIN");
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Conversation conversation) {
        service.addNewConversation(conversation);
    }
}
