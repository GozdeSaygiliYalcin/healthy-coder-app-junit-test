package com.junit.healthycoderapp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DietPlan {

    private int calories;
    private int protein;
    private int fat;
    private int carbohydrate;
}
