package com.example.e_commer.booking.controller;

import com.example.e_commer.booking.entity.User;
import com.example.e_commer.booking.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public Object create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping
    public Object getListUser(){
        return userService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailUser(@PathVariable("id") Long id){
        return userService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleted(id);
    }

    @PutMapping
    public Object updateUser(@RequestBody User user){
        return userService.update(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
    try {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        User user = userService.login(email, password);
        return ResponseEntity.ok(user);
    } catch (RuntimeException e) {
        return ResponseEntity.status(401).body(Map.of("message", e.getMessage()));
    } catch (Exception e) {
        return ResponseEntity.status(500).body(Map.of("message", "Terjadi kesalahan server"));
    }
}

}
