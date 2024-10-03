package com.example.phonebook.service;

import com.example.phonebook.model.Auth;
import com.example.phonebook.model.Contact;
import com.example.phonebook.repository.AuthRepository;
import com.example.phonebook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    private final AuthRepository authRepository;
//    private final SecurityConfig securityConfig;

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
//        this.securityConfig = securityConfig;
    }

    public void register(Auth user) {
        if (authRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email sudah terdaftar");
        }
        if (user.getPassword().length() < 8) {
            throw new IllegalStateException("Password Harus 8 Character");
        }
//        String passwordEncode = securityConfig.passwordEncoder().encode(user.getPassword());
//        user.setPassword(passwordEncode);
        authRepository.save(user);
    }
//    public void login(String email, String password) {
//        if (authRepository.findByEmail(email).isEmpty()) {
//            throw new IllegalStateException("User tidak terdaftar");
//        }
//
//    }
}