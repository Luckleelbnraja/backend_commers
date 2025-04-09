package com.example.e_commer.booking.controller;


import com.example.e_commer.booking.entity.Shipping;
import com.example.e_commer.booking.service.ShippingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
     private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }


    @PostMapping
    public Object create(@RequestBody Shipping shipping){
        return shippingService.create(shipping);
    }

    @GetMapping
    public Object getListShipping(){
        return shippingService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailShipping(@PathVariable("id") Long id){
        return shippingService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteShipping(@PathVariable("id") Long id){
        shippingService.deleted(id);
    }
}
