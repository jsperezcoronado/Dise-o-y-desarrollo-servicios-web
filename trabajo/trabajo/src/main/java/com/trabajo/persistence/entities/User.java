package com.trabajo.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuarios")
public class User {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long idUser;

        private String name;
        private String username;
        private String password;
}
