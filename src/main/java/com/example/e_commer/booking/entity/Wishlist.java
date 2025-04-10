package com.example.e_commer.booking.entity;


import com.example.e_commer.booking.entity.User;
import com.example.e_commer.booking.entity.Product;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
