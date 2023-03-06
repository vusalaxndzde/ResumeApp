package com.mycompany.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok().body("Salam");
    }

}
