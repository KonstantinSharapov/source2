package com.company;

public class Main {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(30); // max 30 discs
        hanoi.solve();
        System.out.println(hanoi.towerA);
        System.out.println(hanoi.towerB);
        System.out.println(hanoi.towerC);
    }
}
