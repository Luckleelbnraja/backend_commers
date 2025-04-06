package com.example.e_commer.booking.controller;

import com.example.e_commer.booking.entity.User;
import com.example.e_commer.booking.service.UserService;
import org.springframework.web.bind.annotation.*;


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
}
