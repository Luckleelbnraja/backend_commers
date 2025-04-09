package com.example.e_commer.booking.service;


import com.example.e_commer.booking.entity.Shipping;
import com.example.e_commer.booking.repository.ShippingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingService {
    private final ShippingRepository shippingRepository;

    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public Object create(Shipping shipping){
        return shippingRepository.save(shipping);
    }

    public Object getListData(){
        return shippingRepository.findAll();
    }

    public Object getDataDetail(Long id){
        return shippingRepository.findById(id).get();
    }

    public void deleted(Long id){
        Optional<Shipping> shipping = shippingRepository.findById(id);
        shipping.ifPresent(shippingRepository::delete);
    }
}
