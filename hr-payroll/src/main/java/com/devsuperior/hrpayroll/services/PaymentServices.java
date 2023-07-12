package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.controllers.WorkerEntity;
import com.devsuperior.hrpayroll.entitites.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServices {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;
    public PaymentEntity getPayment(long workerId, int days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", ""+workerId);

        WorkerEntity worker = restTemplate.getForObject(workerHost + "/workers/{id}", WorkerEntity.class, uriVariables);
        return new PaymentEntity(worker.getName(), worker.getDailyIncome(), days);
    }
}
