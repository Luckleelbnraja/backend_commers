package com.example.e_commer.booking.controller;


import com.example.e_commer.booking.entity.Wishlist;
import com.example.e_commer.booking.service.WishlistService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }


    @PostMapping
    public Object create(@RequestBody Wishlist wishlist){
        return wishlistService.create(wishlist);
    }

    @GetMapping
    public Object getListWishlist(){
        return wishlistService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailWishlist(@PathVariable("id") Long id){
        return wishlistService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWishlist(@PathVariable("id") Long id){
        wishlistService.deleted(id);
    }
}
