package com.distributedlibrary.central.controller;

import com.distributedlibrary.central.dto.RegisterDTO;
import com.distributedlibrary.central.model.User;
import com.distributedlibrary.central.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/central")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto){
        final var response = userService.register(dto);
        return  response ?
                ResponseEntity.status(HttpStatus.OK).body(response):
                ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @PostMapping("/rent/{id}")
    public ResponseEntity<?> rentBook(@PathVariable("id") final String id){
        final var response = userService.rentBook(UUID.fromString(id));
        return  response ?
                ResponseEntity.status(HttpStatus.OK).body(response):
                ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<?> returnBook(@PathVariable("id") final String id){
        final var response = userService.returnBook(UUID.fromString(id));
        return  response ?
                ResponseEntity.status(HttpStatus.OK).body(response):
                ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }
}
