package com.garage.lib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WantController {

    @Autowired
    WantRepo dao;
    
    @GetMapping("/want")
    public List<Want> getWant(){
        List<Want> foundWant = dao.findAll();
        return foundWant;
    }
    
    @PostMapping("/want")
    public ResponseEntity<Want> postWant(@RequestBody Want want){

        // Saving to DB using an instance of the repo Interface.
        Want createdWant = dao.save(want);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdWant);
    }
}