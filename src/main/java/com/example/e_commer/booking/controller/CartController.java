package com.example.e_commer.booking.controller;

import com.example.e_commer.booking.entity.Cart;
import com.example.e_commer.booking.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart") // Ganti base URL ke /api/cart
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Endpoint untuk menambahkan produk ke keranjang
    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    // Endpoint untuk mendapatkan semua item dalam keranjang
    @GetMapping
    public Object getListCart() {
        return cartService.getListData();
    }

    // Endpoint untuk mendapatkan detail cart berdasarkan ID
    @GetMapping("/{id}")
    public Object getDetailCart(@PathVariable("id") Long id) {
        return cartService.getDataDetail(id);
    }

    // Endpoint untuk menghapus item di cart berdasarkan ID
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Long id) {
        cartService.deleted(id);
    }

    // Endpoint untuk memperbarui item di cart
    @PutMapping
    public Object updateCart(@RequestBody Cart cart) {
        return cartService.update(cart);
    }
}
