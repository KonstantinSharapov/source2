package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gene {

    public enum Nucleotide{
        A, C, G, T
    }
    private ArrayList<Codon> codons = new ArrayList<>();

    public static class Codon implements Comparable<Codon>{
        public final Nucleotide first, second, third;
        private final Comparator<Codon> comparator =
                Comparator.comparing((Codon c) -> c.first)
                        .thenComparing((Codon c) -> c.second)
                        .thenComparing((Codon c) -> c.third);

        public Codon(String codonStr){
            first = Nucleotide.valueOf(codonStr.substring(0,1));
            second = Nucleotide.valueOf(codonStr.substring(1,2));
            third = Nucleotide.valueOf(codonStr.substring(2,3));
        }

        @Override
        public int compareTo(Codon other){
            //Сначала сравниваем первый обьект, потом второй, затем третий
            //Первый имеет приоритет над вторым, как второй над третьим
            return comparator.compare(this,other);
        }
    }

    //Из каждых трех символов в строке сформировать кодон
    public Gene(String geneStr){
        for (int i = 0; i < geneStr.length()-3; i+=3){
            codons.add(new Codon(geneStr.substring(i, i + 3)));
        }
    }

    // линейный поиск который просматривает всех элементы в массиве.
    public boolean linearContains(Codon key){
        for (Codon codon : codons){
            if (codon.compareTo(key)==0){
                return true;
            }
        }
        return false;
    }

    public boolean binaryContains(Codon key){
        // бинарный поиск работает  только с отсортированными коллекциями
        ArrayList<Codon> sortedCodons = new ArrayList<>(codons);
        Collections.sort(sortedCodons);
        int low = 0;
        int high = sortedCodons.size() - 1;
        while (low <= high){
            int middle = (low + high) / 2;
            int comparison = codons.get(middle).compareTo(key);
            if(comparison < 0){ // средний кодон меньше искомого
                low = middle + 1;
            } else if (comparison > 0){
                high = middle - 1;
            } else { // средний кодон равен искомому
                return true;
            }
        }
        return false;
    }
}
