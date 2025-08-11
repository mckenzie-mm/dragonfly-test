package com.example.demo.conversation;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping(path = "{permission}/all")
    public List<ConversationDTO> getConversations(@PathVariable("permission") String permission) {
        return service.getConversations(permission.toUpperCase());
    }
    @GetMapping(path = "{permission}/{id}")
    public Conversation getConversation(@PathVariable("id") Long id, @PathVariable("permission") String permission) {
        return service.getConversation(id, permission.toUpperCase());
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Conversation conversation) {
        service.addNewConversation(conversation);
    }
}
