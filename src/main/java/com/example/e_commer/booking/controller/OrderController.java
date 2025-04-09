package com.example.e_commer.booking.controller;


import com.example.e_commer.booking.entity.Order;
import com.example.e_commer.booking.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public Object create(@RequestBody Order order){
        return orderService.create(order);
    }

    @GetMapping
    public Object getListOrder(){
        return orderService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailOrder(@PathVariable("id") Long id){
        return orderService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleted(id);
    }
}
