package com.distributedlibrary.city.controller;

import com.distributedlibrary.city.dto.RegisterDTO;
import com.distributedlibrary.city.dto.RentalDTO;
import com.distributedlibrary.city.dto.ReturnDTO;
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
                ResponseEntity.status(HttpStatus.OK).body("Account successfully created!"):
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Account creation canceled.");
    }

    @PostMapping("/rent")
    public ResponseEntity<?> rentBook(@RequestBody RentalDTO dto){
        final var response = service.rentBook(dto);
        return  response ?
                ResponseEntity.status(HttpStatus.OK).body("Book successfully rented!"):
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Book rental canceled.");
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnBook(@RequestBody ReturnDTO dto){
        final var response = service.returnBook(dto);
        return  response ?
                ResponseEntity.status(HttpStatus.OK).body("Book successfully returned!"):
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Book rental cancellation failed.");
    }
}
