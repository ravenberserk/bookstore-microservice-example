package com.example.authservice.repository;

import com.example.authservice.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
