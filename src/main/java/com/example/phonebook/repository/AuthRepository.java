package com.example.phonebook.repository;

import com.example.phonebook.model.Auth;
import com.example.phonebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByEmail(String email);
}
