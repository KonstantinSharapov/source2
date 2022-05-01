package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;


//здесь короч множественный поиск, точней этот поиск найдет все возможные типы данных и обьекты тоже
public class Main {

    public static <T extends Comparable<T>> boolean linearContains(List<T> list, T key){
        for (T item : list){
            if(item.compareTo(key)==0)
                return true; //просто перебираем список
        }
        return false;
    }

    //предполагаеться что список отсортирован
    public static <T extends Comparable<T>> boolean binaryContains(List<T> list,T key){
        int low = 0;
        int high = list.size() - 1;
        while (low <= high){
            int middle = (low + high)/2;
            int comparison = list.get(middle).compareTo(key);
            if (comparison < 0){ // средний кодон меньше исходного
                low = middle + 1;
            }
            else if (comparison > 0){ // средний кодон больше исходного
                high = middle - 1;
            }
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(linearContains(List.of(1,5,15,15,15,20),5)); // true for linear search
        System.out.println(binaryContains(List.of("a","b","c","d","z","f"),"f")); //true for binary search
        System.out.println(binaryContains(List.of("john","mark","ronald","sarah"),"sheila")); // false for binary search
    }
}
