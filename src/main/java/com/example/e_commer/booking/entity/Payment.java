package com.example.e_commer.booking.entity;

import com.example.e_commer.booking.entity.Order;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
}
