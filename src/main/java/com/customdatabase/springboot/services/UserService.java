package com.customdatabase.springboot.services;

import com.customdatabase.springboot.dtos.UserDTO;
import com.customdatabase.springboot.entities.UserEntity;
import com.customdatabase.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public UserDTO addUser(UserDTO userDTO){
        UserEntity userEntity = userRepository.save(new UserEntity(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword())));
        return new UserDTO(userEntity.getUsername(), userEntity.getPassword());
    }
    public UserDTO getUser(String s){
        UserEntity user = userRepository.findByUsername(s);
        return new UserDTO(user.getUsername(), user.getPassword());
    }
}
