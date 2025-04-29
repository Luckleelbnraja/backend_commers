package com.example.e_commer.booking.service;

import com.example.e_commer.booking.entity.Cart;
import com.example.e_commer.booking.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
     private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Fungsi untuk menambahkan item ke keranjang
    public Cart create(Cart cart){
        return cartRepository.save(cart); // Menyimpan cart yang baru
    }

    // Fungsi untuk mendapatkan semua item di cart
    public List<Cart> getListData(){
        return cartRepository.findAll();
    }

    // Fungsi untuk mendapatkan detail cart berdasarkan ID
    public Cart getDataDetail(Long id){
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart item not found with id " + id));
    }

    // Fungsi untuk menghapus item di cart berdasarkan ID
    public void deleted(Long id){
        Optional<Cart> cart = cartRepository.findById(id);
        cart.ifPresent(cartRepository::delete);
    }

    // Fungsi untuk memperbarui cart (opsional)
    public Cart update(Cart cart){
        // Cek apakah cart dengan ID tertentu ada, jika ada perbarui, jika tidak ada lempar exception
        if (cartRepository.existsById(cart.getId())) {
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Cart item not found with id " + cart.getId());
        }
    }
}
