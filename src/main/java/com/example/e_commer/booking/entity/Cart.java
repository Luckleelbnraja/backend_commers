package com.example.e_commer.booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.e_commer.booking.entity.User;
import com.example.e_commer.booking.entity.Product;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;
    
    private int quantity; 
}
