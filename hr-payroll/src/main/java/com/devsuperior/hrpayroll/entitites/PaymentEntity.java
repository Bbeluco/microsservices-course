package com.devsuperior.hrpayroll.entitites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity implements Serializable {

    private String name;
    private double dailyIncome;
    private int days;

    public double getTotal(){
        return this.dailyIncome * this.days;
    }
}
