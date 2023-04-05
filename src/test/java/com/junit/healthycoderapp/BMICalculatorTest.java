package com.junit.healthycoderapp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void testIsDietRecommended() {

        // Test case where BMI is below threshold
        assertFalse(BMICalculator.isDietRecommended(60, 1.75)); // BMI = 19.59

        // Test case where BMI is above threshold
        assertTrue(BMICalculator.isDietRecommended(80, 1.75)); // BMI = 26.12

        // Test case where height is zero (should throw ArithmeticException)
        assertThrows(ArithmeticException.class, () -> BMICalculator.isDietRecommended(60, 0.0));
    }

    @Test
    void testFindCoderWithWorstBMI() {

        //create a coder list
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new Coder(1.65, 60, 35, Gender.FEMALE));
        coderList.add(new Coder(1.75, 75, 39, Gender.MALE));
        coderList.add(new Coder(1.55, 90, 45, Gender.MALE));

        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coderList);
        assertNotNull(coderWithWorstBMI);
        assertEquals(1.55, coderWithWorstBMI.getHeight());

        coderList.add(new Coder(0.0, 0.0, 50, Gender.MALE));
        assertThrows(ArithmeticException.class, () -> BMICalculator.findCoderWithWorstBMI(coderList));
    }

    @Test
    void testGetBMIScores() {

        Coder coder1 = new Coder(1.8, 75, 25, Gender.MALE);
        Coder coder2 = new Coder(1.6, 60, 30, Gender.FEMALE);
        Coder coder3 = new Coder(1.7, 80, 35, Gender.MALE);
        List<Coder> coders = Arrays.asList(coder1, coder2, coder3);

        double[] expectedScores = {23.15, 23.44, 27.68};
        double[] actualScores = BMICalculator.getBMIScores(coders);

        assertArrayEquals(expectedScores, actualScores, 0.01);
    }
}