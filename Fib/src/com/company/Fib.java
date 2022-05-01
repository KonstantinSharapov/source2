package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Fib {
    private int last = 0, next = 1;
    private Map<Integer, Integer> memo = new HashMap<>(Map.of(0,0,1,1));


    private IntStream strFib(){
        return IntStream.generate(() -> {
            int oldLast = last;
            last = next;
            next = oldLast + next;
            return oldLast;
        });
    }
    public void streamFib(int n){
        strFib().limit(n).forEachOrdered(System.out::println);
    }


    private int iteFib(int n){
        int last = 0, next = 1;
        for (int i = 0; i < n; i++){
            int oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }
    public void iterativeFib(int n){
        System.out.println(iteFib(n-1));
    }


    private int mFib(int n){
        if(!memo.containsKey(n)) {
            memo.put(n,mFib(n - 1) + mFib(n - 2));
        }
        return memo.get(n);
    }
    public void mapFib(int n){
        System.out.println(mFib(n-1));
    }
}
