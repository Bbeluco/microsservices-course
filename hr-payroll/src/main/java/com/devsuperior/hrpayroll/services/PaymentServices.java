package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entitites.PaymentEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {
    public PaymentEntity getPayment(long workerId, int days){
        return new PaymentEntity("Bruno", 200.5, days);
    }
}
