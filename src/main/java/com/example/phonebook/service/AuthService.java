package com.example.phonebook.service;

import com.example.phonebook.Utils.DataNotFoundException;
import com.example.phonebook.config.SecurityConfig;
import com.example.phonebook.dto.AuthDto;
import com.example.phonebook.model.Auth;
import com.example.phonebook.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final SecurityConfig securityConfig;

    @Autowired
    public AuthService(AuthRepository authRepository, SecurityConfig securityConfig) {
        this.authRepository = authRepository;
        this.securityConfig = securityConfig;
    }

    public void register(Auth user) {
        if (authRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email sudah terdaftar");
        }
        if (user.getPassword().length() < 8) {
            throw new IllegalStateException("Password Harus 8 Character");
        }
        String passwordEncode = securityConfig.passwordEncoder().encode(user.getPassword());
        user.setPassword(passwordEncode);
        authRepository.save(user);
    }

    public AuthDto findByUsernameOrEmail(String keyword) {
        // mencari data berdasarkan username or email
        Auth user = authRepository.findByUsernameOrEmail(keyword, keyword).orElseThrow(() -> new DataNotFoundException("Data dengan username atau email " +keyword+" tidak ditemukan"));

        // dto agar tidak semua field(termasuk password) dimunculkan
        AuthDto auth = new AuthDto();
        auth.setUsername(user.getUsername());
        auth.setEmail(user.getEmail());
        return auth;
    }

//    public void login(String email, String password) {
//        if (authRepository.findByEmail(email).isEmpty()) {
//            throw new IllegalStateException("User tidak terdaftar");
//        }
//
//    }
}