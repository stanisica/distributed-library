package com.distributedlibrary.central.service;

import com.distributedlibrary.central.dto.RegisterDTO;
import com.distributedlibrary.central.mapper.UserMapper;
import com.distributedlibrary.central.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public boolean register(RegisterDTO dto){
        if(checkIfExists(dto.getJmbg())) return false;
        var newUser = userMapper.DtoToEntity(dto);
        userRepository.save(newUser);
        return true;
    }

    private boolean checkIfExists(String jmbg){
        return userRepository.findByJmbg(jmbg) != null;
    }

    public boolean rentBook(UUID id){
        var user = userRepository.findById(id).get();
        var response = user.rentBook();
        userRepository.save(user);
        return response;
    }

    public boolean returnBook(UUID id){
        var user = userRepository.findById(id).get();
        var response  = user.returnBook();
        userRepository.save(user);
        return response;
    }
}
