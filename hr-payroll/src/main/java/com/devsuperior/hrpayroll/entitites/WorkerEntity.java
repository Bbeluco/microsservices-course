package com.devsuperior.hrpayroll.entitites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerEntity implements Serializable {
    private Long id;
    private String name;
    private Double dailyIncome;
}
