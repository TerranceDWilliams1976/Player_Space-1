package com.garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HadController {

    @Autowired
    com.garage.repo.HadRepo dao;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/had")
    public List<com.garage.models.Had> getHad(){
        List<com.garage.models.Had> foundHad = dao.findAll();
        return foundHad;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/had")
    public ResponseEntity<com.garage.models.Had> postHad(@RequestBody com.garage.models.Had had){

        // Saving to DB using an instance of the repo Interface.
    	com.garage.models.Had createdHad = dao.save(had);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdHad);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/had/{id}")
    public ResponseEntity<String> deleteHad(@PathVariable(value = "id") Integer id){
        // Saving to DB using an instance of the repo Interface.
    	dao.deleteById(id);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok("Game removed from library");
    }
}