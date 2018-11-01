package com.garage.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Autowired
    InfoRepo dao;
    
    @GetMapping("/info")
    public List<Info> getInfo(){
        List<Info> foundInfo = dao.findAll();
        return foundInfo;
    }
    
    @PostMapping("/info")
    public ResponseEntity<Info> postInfo(@RequestBody Info info){

        // Saving to DB using an instance of the repo Interface.
        Info createdInfo = dao.save(info);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdInfo);
    }

}