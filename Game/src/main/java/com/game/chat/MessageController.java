package com.game.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageRepo dao;
    
    @GetMapping("/chat")
    public List<Message> getMessages(){
        List<Message> foundMessages = dao.findAll();
        return foundMessages;
    }
    
    @PostMapping("/chat")
    public ResponseEntity<Message> postMessage(@RequestBody Message message){

        // Saving to DB using an instance of the repo Interface.
        Message createdMessage = dao.save(message);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdMessage);
    }

}