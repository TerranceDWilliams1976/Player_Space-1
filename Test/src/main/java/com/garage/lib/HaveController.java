package com.garage.lib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaveController {

    @Autowired
    HaveRepo dao;
    
    @GetMapping("/have")
    public List<Have> getHave(){
        List<Have> foundHave = dao.findAll();
        return foundHave;
    }
    
    @PostMapping("/have")
    public ResponseEntity<Have> postHave(@RequestBody Have have){

        // Saving to DB using an instance of the repo Interface.
        Have createdHave = dao.save(have);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdHave);
    }
}