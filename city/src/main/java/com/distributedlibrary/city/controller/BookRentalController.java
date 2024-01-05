package com.distributedlibrary.city.controller;

import com.distributedlibrary.city.dto.RegisterDTO;
import com.distributedlibrary.city.dto.RentalDTO;
import com.distributedlibrary.city.service.BookRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class BookRentalController {
    private final BookRentalService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO dto){
        final var response = service.register(dto);
        return  response ?
                ResponseEntity.status(HttpStatus.OK).body("User added!"):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists!");
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody RentalDTO dto){
//
//    }
}
