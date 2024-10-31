package com.trabajo.domain.services;

import com.trabajo.domain.dtos.UserDTO;
import com.trabajo.domain.mapper.UserMapper;
import com.trabajo.persistence.entities.User;
import com.trabajo.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public UserDTO save(UserDTO userDTO) {
        userRepository.save(UserMapper.toEntity(userDTO));
        return userDTO;
    }


    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDTO);
    }

    public Optional<UserDTO> findByUserAndPassword(String usuario, String password) {
        User user = userRepository.findByUsernameAndPassword(usuario, password);
        if (user != null) {
            return Optional.of(UserMapper.toDTO(user));
        } else {
            return Optional.empty();
        }
    }
}
