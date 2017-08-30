package com.example.admin.androidtesting;

/**
 * Created by Admin on 8/29/2017.
 */

public class Calculation {

    double val1, val2;
    public Addition addition = new Addition();
    public Subtraction subtraction = new Subtraction();
    public Multiplication multiplication = new Multiplication();
    public Division division = new Division();

    public Calculation(Double val1, Double val2){
        this.val1 = val1;
        this.val2 = val2;
    }

    public double add(){

        //Addition addition = new Addition();

        return addition.add(val1, val2);
    }

    public double subtract(){
        return subtraction.subtract(val1 ,val2);
    }
    public double multiply(){
        return multiplication.multiply(val1,val2);
    }
    public double divide(){
        return division.divide(val1,val2);
    }
}
