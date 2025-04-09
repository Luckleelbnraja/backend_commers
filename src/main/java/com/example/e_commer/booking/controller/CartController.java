package com.example.e_commer.booking.controller;

import com.example.e_commer.booking.entity.Cart;
import com.example.e_commer.booking.service.CartService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping
    public Object create(@RequestBody Cart cart){
        return cartService.create(cart);
    }

    @GetMapping
    public Object getListCart(){
        return cartService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailCart(@PathVariable("id") Long id){
        return cartService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Long id){
        cartService.deleted(id);
    }

    @PutMapping
    public Object updateCart(@RequestBody Cart cart){
        return cartService.update(cart);
    }
}
