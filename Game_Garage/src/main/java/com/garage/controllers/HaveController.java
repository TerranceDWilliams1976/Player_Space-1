package com.garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaveController {

    @Autowired
    com.garage.repo.HaveRepo dao;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/have")
    public List<com.garage.models.Have> getHave(){
        List<com.garage.models.Have> foundHave = dao.findAll();
        return foundHave;
    }
    
    @PostMapping("/have")
    public ResponseEntity<com.garage.models.Have> postHave(@RequestBody com.garage.models.Have have){

        // Saving to DB using an instance of the repo Interface.
    	com.garage.models.Have createdHave = dao.save(have);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdHave);
    }
}