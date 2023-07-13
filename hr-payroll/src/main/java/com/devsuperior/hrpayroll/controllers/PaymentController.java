package com.devsuperior.hrpayroll.controllers;

import com.devsuperior.hrpayroll.entitites.PaymentEntity;
import com.devsuperior.hrpayroll.services.PaymentServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentServices paymentServices;

    @HystrixCommand(fallbackMethod = "getPaymentMocked")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<PaymentEntity> getPayment(@PathVariable long workerId, @PathVariable int days){
        return ResponseEntity.ok(paymentServices.getPayment(workerId, days));
    }

    public ResponseEntity<PaymentEntity> getPaymentMocked(long workerId, int days) {
        PaymentEntity payment = new PaymentEntity("Mock", 237.69, days);
        return ResponseEntity.ok(payment);
    }
}
