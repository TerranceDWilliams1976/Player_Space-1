package com.garage.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garage.models.Want;

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
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/want")
    public ResponseEntity<com.garage.models.Want> postWant(@RequestBody com.garage.models.Want want){

        // Saving to DB using an instance of the repo Interface.
    	com.garage.models.Want createdWant = dao.save(want);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdWant);
    }
    
    @CrossOrigin(origins = "http://localhost:4200",methods=RequestMethod.DELETE)
    @DeleteMapping("/want/{id}")
    public ResponseEntity<String> postDeleteWant(@PathVariable(value = "id") int x){

        // Saving to DB using an instance of the repo Interface.
    	dao.deleteById(x);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok("Might Be Deleted?");
    }
    
}