package com.garage.lib;

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
    LibRepo dao;
    
    @GetMapping("/search")
    public List<Lib> getLib(){
        List<Lib> foundLib = dao.findAll();
        return foundLib;
    }
    
    @PostMapping("/search")
    public ResponseEntity<Lib> postLib(@RequestBody Lib lib){

        // Saving to DB using an instance of the repo Interface.
        Lib createdLib = dao.save(lib);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdLib);
    }

}