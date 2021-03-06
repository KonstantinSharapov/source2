package com.company;

public class Main {

    public static void main(String[] args) {
        String geneStr = "ACGTGGCTTCATTCTACTACTATTTTACGGTTTATACTACTACCCCCTTT";
        Gene myGene = new Gene(geneStr);
        Gene.Codon acg = new Gene.Codon("ACG");
        Gene.Codon gat = new Gene.Codon("GAT");
        System.out.println(myGene.linearContains(acg)); //true
        System.out.println(myGene.linearContains(gat)); //false
        System.out.println(myGene.binaryContains(acg)); //true
        System.out.println(myGene.binaryContains(gat)); //false
    }
}
