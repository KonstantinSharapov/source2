package com.company;

public class Main {

    // 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + ...
    public static double calculatorPi(int nTerms){
        final double numerator = 4.0;
        double denominator = 1.0;
        double operation = 1.0;
        double pi = 0.0;
        for (int i = 0; i < nTerms; i++){
            pi = pi + operation * (numerator / denominator);
            denominator = denominator + 2.0;
            operation = operation * -1.0;
        }
        return pi;
    }

    public static void main(String[] args) {
        System.out.println(calculatorPi(1000000000));
    }
}
