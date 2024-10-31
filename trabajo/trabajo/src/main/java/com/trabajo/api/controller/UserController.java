package com.trabajo.api.controller;

import com.trabajo.domain.dtos.UserDTO;
import com.trabajo.domain.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Api")
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping(value = ("/Login"))
    public ResponseEntity<?> findUserAndPassword(@RequestBody UserDTO userDTO) {
        Optional<UserDTO> userDTOOptional;
        userDTOOptional = userServices.findByUserAndPassword(userDTO.getUser(), userDTO.getPassword());
        if (userDTOOptional.isPresent()) {
            return ResponseEntity.ok(userDTOOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/Guardar")
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userServices.save(userDTO);
    }

    @GetMapping(value = "/Consultar")
    public List<UserDTO> get() {
        return userServices.getAll();
    }
}
