package com.trabajo.persistence.repositories;

import com.trabajo.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsernameAndPassword(String username, String password);

}
