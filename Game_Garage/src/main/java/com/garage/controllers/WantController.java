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
public class WantController {

    @Autowired
    com.garage.repo.WantRepo dao;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/want")
    public List<com.garage.models.Want> getWant(){
        List<com.garage.models.Want> foundWant = dao.findAll();
        return foundWant;
    }
    
    @PostMapping("/want")
    public ResponseEntity<com.garage.models.Want> postWant(@RequestBody com.garage.models.Want want){

        // Saving to DB using an instance of the repo Interface.
    	com.garage.models.Want createdWant = dao.save(want);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdWant);
    }
}