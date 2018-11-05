package com.garage.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibController {

    @Autowired
    com.garage.repo.LibRepo dao;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/search")
    public List<com.garage.models.Lib> getLib(){
        List<com.garage.models.Lib> foundLib = dao.findAll();
        return foundLib;
    }
    
    @PostMapping("/search")
    public ResponseEntity<com.garage.models.Lib> postLib(@RequestBody com.garage.models.Lib lib){

        // Saving to DB using an instance of the repo Interface.
    	com.garage.models.Lib createdLib = dao.save(lib);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdLib);
    }
}