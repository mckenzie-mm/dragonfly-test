package com.example.demo.conversation;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ConversationService {
    
    ArrayList<Conversation> myList; // shortened name from 'conversationList'

    public ConversationService() {

        // This is a dummy array. Indexing would normally be implemented
        // This would normally be in a database of conversations
        // and the calls would be made as SQL and not list manipulations
        // (if using sql database such as postgres).
        // I would normally use a different service for ADMIN and USER
        // to minimise the risk of the accidental publishing of non-authenticated
        // data

        myList = new ArrayList<Conversation>();

        myList.add(new Conversation(
            1L,
            "Title 1",
            "Sentence 1",
            "Paragraph 1",
            LocalDate.of(2025, Month.AUGUST, 1),
            "USER"
        ));

        myList.add(new Conversation(
            2L,
            "Title 2",
            "Sentence 2",
            "Paragraph 2",
            LocalDate.of(2025, Month.AUGUST, 2),
            "USER"
        ));

        myList.add(new Conversation(
            3L,
            "Title 3",
            "Sentence 3",
            "Paragraph 3",
            LocalDate.of(2025, Month.AUGUST, 3),
            "ADMIN"
        ));

        myList.add(new Conversation(
            4L,
            "Title 4",
            "Sentence 4",
            "Paragraph 4",
            LocalDate.of(2025, Month.AUGUST, 4),
            "USER"
        ));
    }

    public List<ConversationDTO> getConversations(String permission) {
        List<ConversationDTO> listDTO = myList.stream().map(obj -> 
                    ConversationDTO.fromConversation(obj)
                ).collect(Collectors.toList());   

        if (permission.equals("ADMIN")) {
            return listDTO;
        } else {
            // Filter based on permission
            return listDTO.stream()
            .filter(obj -> obj.getPermission().equals("USER")).collect(Collectors.toList());          
        }
    }

     public Conversation getConversation(Long targetId, String permission) {
        Conversation foundConversation = myList.stream()
            .filter(obj -> obj.getId() == targetId) // Filter based on ID
            .findFirst().orElse(null); // Get the first matching element
        if (foundConversation != null) {
            if (permission.equals("ADMIN")) {
                return foundConversation;
            }
            if (foundConversation.getPermission().equals(permission)) {
                return foundConversation;
            } 
        }
        throw new IllegalStateException("not found");
    }

    public void addNewConversation(Conversation conversation) {

        Long id = (long) myList.size() + 1L; // have not implemented indexing on array

        myList.add(new Conversation(
            id,
            conversation.getTitle(),
            conversation.getSentence(),
            conversation.getParagraph(),
            conversation.getEdited(),
            conversation.getPermission()
        ));
    }
}
