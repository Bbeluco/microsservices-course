package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entitites.WorkerEntity;
import com.devsuperior.hrpayroll.entitites.PaymentEntity;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentServices {
    @Autowired
    private WorkerFeignClient workerFeignClient;
    public PaymentEntity getPayment(long workerId, int days){
        WorkerEntity worker = workerFeignClient.findWorkerById(workerId).getBody();
        return new PaymentEntity(worker.getName(), worker.getDailyIncome(), days);
    }
}
