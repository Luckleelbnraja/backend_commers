package com.example.e_commer.booking.service;

import com.example.e_commer.booking.entity.Order;
import com.example.e_commer.booking.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Object create(Order order){
        return orderRepository.save(order);
    }

    public Object getListData(){
        return orderRepository.findAll();
    }

    public Object getDataDetail(Long id){
        return orderRepository.findById(id).get();
    }

    public void deleted(Long id){
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(orderRepository::delete);
    }
}

