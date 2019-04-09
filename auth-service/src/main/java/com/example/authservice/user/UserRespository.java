package com.example.authservice.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserRespository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
