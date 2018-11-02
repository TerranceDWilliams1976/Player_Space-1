package com.garage.lib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HadController {

    @Autowired
    HadRepo dao;
    
    @GetMapping("/had")
    public List<Had> getHad(){
        List<Had> foundHad = dao.findAll();
        return foundHad;
    }
    
    @PostMapping("/had")
    public ResponseEntity<Had> postHad(@RequestBody Had had){

        // Saving to DB using an instance of the repo Interface.
        Had createdHad = dao.save(had);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdHad);
    }
}