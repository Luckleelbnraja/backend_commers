package com.example.e_commer.booking.service;

import com.example.e_commer.booking.entity.User;
import com.example.e_commer.booking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object create(User user) {
        return userRepository.save(user);
    }

    public Object getListData() {
        return userRepository.findAll();
    }

    public Object getDataDetail(Long id) {
        return userRepository.findById(id).get();
    }

    public void deleted(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }

    public User update(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isEmpty()) {
            throw new RuntimeException("User tidak ditemukan");
        }
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Email tidak ditemukan");
        }

        User user = optionalUser.get();
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Password salah");
        }

        return user;
    }
}
