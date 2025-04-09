package com.example.e_commer.booking.repository;

import com.example.e_commer.booking.entity.Cart;
import com.example.e_commer.booking.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.e_commer.booking.entity.Cart;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
