package com.company;

public class AppFib {

    public static void main(String[] args) {

        int n = 20;

        Fib fib = new Fib();
        fib.iterativeFib(n);
        System.out.println(" ");
        fib.mapFib(n);
        System.out.println(" ");
        fib.streamFib(n);

    }
}
