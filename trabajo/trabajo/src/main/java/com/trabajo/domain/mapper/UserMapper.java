package com.trabajo.domain.mapper;

import com.trabajo.domain.dtos.UserDTO;
import com.trabajo.persistence.entities.User;

public class UserMapper {

    //METODO PARA CONVERTIR UNA ENTIDAD EN DTO
    public static UserDTO toDTO (User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUser(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setName(user.getName());
        return userDTO;
    }

    //METODO PARA CONVERTIR UN DTO EN ENTIDAD
    public static User toEntity (UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUser());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
