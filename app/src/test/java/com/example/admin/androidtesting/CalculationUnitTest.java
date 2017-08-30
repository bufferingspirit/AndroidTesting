package com.example.admin.androidtesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Admin on 8/29/2017.
 */

public class CalculationUnitTest {

    Calculation calculation;

    @Before
    public void Setup(){

        calculation = new Calculation(9.0,9.0);

        calculation.addition = mock(Addition.class);
        calculation.subtraction = mock(Subtraction.class);
        calculation.multiplication = mock(Multiplication.class);
        calculation.division = mock(Division.class);

    }

    @Test
    public void testing_addition_should_add_two_numbers(){
        when(calculation.addition.add(9.0,9.0)).thenReturn(20.0);
        assertEquals(calculation.add(), 18.0, 0);
    }

    @Test
    public void testing_subtraction_should_minus_two_numbers(){
        when(calculation.subtraction.subtract(9.0,9.0)).thenReturn(0.0);
        assertEquals(calculation.subtract(), 0.0, 0);
    }

    @Test
    public void testing_multiplication_should_multiply_two_numbers(){
        when(calculation.multiplication.multiply(9.0,9.0)).thenReturn(81.0);
        assertEquals(calculation.multiply(), 81.0, 0);
    }

    @Test
    public void testing_division_should_divide_two_numbers(){

        assertEquals(calculation.divide(), 1.0, 0);
    }

    @After
    public void tearDown(){

    }

}
