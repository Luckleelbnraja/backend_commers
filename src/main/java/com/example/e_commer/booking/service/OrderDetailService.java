package com.example.e_commer.booking.service;


import com.example.e_commer.booking.entity.OrderDetail;
import com.example.e_commer.booking.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class OrderDetailService {
    
     private final OrderDetailRepository order_detailRepository;

    public OrderDetailService(OrderDetailRepository order_detailRepository) {
        this.order_detailRepository = order_detailRepository;
    }

    public Object create(OrderDetail order_detail){
        return order_detailRepository.save(order_detail);
    }

    public Object getListData(){
        return order_detailRepository.findAll();
    }

    public Object getDataDetail(Long id){
        return order_detailRepository.findById(id).get();
    }

    public void deleted(Long id){
        Optional<OrderDetail> order_detail = order_detailRepository.findById(id);
        order_detail.ifPresent(order_detailRepository::delete);
    }
}
