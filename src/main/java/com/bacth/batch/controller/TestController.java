package com.bacth.batch.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

@RestController
@Log4j2
@RequestMapping("/clients")
public class TestController {

    @GetMapping
    public ResponseEntity<String> create(@Context HttpServletRequest request) {
        return new ResponseEntity<>("Hola", HttpStatus.OK);
    }
}
