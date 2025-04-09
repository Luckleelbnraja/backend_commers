package com.example.e_commer.booking.service;

import com.example.e_commer.booking.entity.Cart;
import com.example.e_commer.booking.repository.CartRepository;
import com.example.e_commer.booking.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
     private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Object create(Cart cart){
        return cartRepository.save(cart);
    }

    public Object getListData(){
        return cartRepository.findAll();
    }

    public Object getDataDetail(Long id){
        return cartRepository.findById(id).get();
    }

    public void deleted(Long id){
        Optional<Cart> cart = cartRepository.findById(id);
        cart.ifPresent(cartRepository::delete);
    }

    public Cart update(Cart cart){
        // check di database if cart exist
        // if exist then update
        // else throw error
        return null;
    }
}

