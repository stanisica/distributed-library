package com.distributedlibrary.central.mapper;

import com.distributedlibrary.central.dto.RegisterDTO;
import com.distributedlibrary.central.model.Address;
import com.distributedlibrary.central.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public User DtoToEntity(RegisterDTO dto){
        final var newAddress = Address.builder()
                .id(UUID.randomUUID())
                .city(dto.getAddress().getCity())
                .street(dto.getAddress().getStreet())
                .number(dto.getAddress().getNumber())
                .build();

        final var newUser = User.builder()
                .id(UUID.randomUUID())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .address(newAddress)
                .jmbg(dto.getJmbg())
                .booksRented(0)
                .build();

        return newUser;
    }
}
