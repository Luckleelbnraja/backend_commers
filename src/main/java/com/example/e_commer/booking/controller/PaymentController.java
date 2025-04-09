package com.example.e_commer.booking.controller;


import com.example.e_commer.booking.entity.Payment;
import com.example.e_commer.booking.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping
    public Object create(@RequestBody Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping
    public Object getListpayment(){
        return paymentService.getListData();
    }

    @GetMapping("/{id}")
    public Object getDetailPayment(@PathVariable("id") Long id){
        return paymentService.getDataDetail(id);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable("id") Long id){
        paymentService.deleted(id);
    }
}
