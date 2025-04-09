package com.example.e_commer.booking.service;


import com.example.e_commer.booking.entity.Payment;
import com.example.e_commer.booking.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Object create(Payment payment){
        return paymentRepository.save(payment);
    }

    public Object getListData(){
        return paymentRepository.findAll();
    }

    public Object getDataDetail(Long id){
        return paymentRepository.findById(id).get();
    }

    public void deleted(Long id){
        Optional<Payment> paymant = paymentRepository.findById(id);
        paymant.ifPresent(paymentRepository::delete);
    }
}

