package com.example.e_commer.booking.service;


import com.example.e_commer.booking.entity.Wishlist;
import com.example.e_commer.booking.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishlistService {
    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Object create(Wishlist wishlist){
        return wishlistRepository.save(wishlist);
    }

    public Object getListData(){
        return wishlistRepository.findAll();
    }

    public Object getDataDetail(Long id){
        return wishlistRepository.findById(id).get();
    }

    public void deleted(Long id){
        Optional<Wishlist> wishlist = wishlistRepository.findById(id);
        wishlist.ifPresent(wishlistRepository::delete);
    }
}
