package com.example.e_commer.booking.controller;


import com.example.e_commer.booking.entity.OrderDetail;
import com.example.e_commer.booking.service.OrderDetailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order_detail")
public class OrderDetailController {
     private final OrderDetailService order_detailService;

    public OrderDetailController(OrderDetailService order_detailService) {
        this.order_detailService = order_detailService;
    }


    @PostMapping
    public Object create(@RequestBody OrderDetail order_detail){
        return order_detailService.create(order_detail);
    }

    @GetMapping
    public Object getListOrderDetail(){
        return order_detailService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailOrderDetail(@PathVariable("id") Long id){
        return order_detailService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable("id") Long id){
        order_detailService.deleted(id);
    }
}
