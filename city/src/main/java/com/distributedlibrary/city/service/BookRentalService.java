package com.distributedlibrary.city.service;

import com.distributedlibrary.city.dto.RegisterDTO;
import com.distributedlibrary.city.dto.RentalDTO;
import com.distributedlibrary.city.mapper.BookRentalMapper;
import com.distributedlibrary.city.repository.BookRentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BookRentalService {
    private final BookRentalRepository repository;
    private final BookRentalMapper mapper;

    public boolean register(RegisterDTO dto){
        try{
            RestTemplate restTemplate = new RestTemplate();
            final var url = "http://localhost:8080/central/register";
            var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<String> response = restTemplate.postForEntity(url, new HttpEntity<>(dto, headers), String.class);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean create(RentalDTO dto){
        var newRental = mapper.DtoToEntity(dto);
        repository.save(newRental);
        return true;
    }
}
