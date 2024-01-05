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
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8080/central";

    public boolean register(RegisterDTO dto){
        try{
            var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<String> response = restTemplate
                    .postForEntity(baseUrl+"/register", new HttpEntity<>(dto, headers), String.class);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean rent(RentalDTO dto){
        try{
            var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<Boolean> elgible = restTemplate
                    .postForEntity(String.format(baseUrl+"/rent/%s", dto.getUserId()), new HttpEntity<>("", headers), Boolean.class);
            return executeRent(elgible.getBody(), dto);
        }catch (Exception e){
            return false;
        }
    }

    private boolean executeRent(boolean elgible, RentalDTO dto){
        if (!elgible) return false;
        var newRental = mapper.DtoToEntity(dto);
        repository.save(newRental);
        return true;
    }
}
