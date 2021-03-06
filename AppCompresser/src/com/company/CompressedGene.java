package com.company;

import java.util.BitSet;
import java.util.Locale;

public class CompressedGene {

    private BitSet bitSet;
    private int length;

    public CompressedGene(String gene){
        compress(gene);
    }

    private void compress(String gene){
        length = gene.length();
        //резервирование пространства для битов ебать нахуй
        bitSet = new BitSet(length*2);
        //преобразование в верхний регистр для парти единых битов
        final String upperGene = gene.toUpperCase();
        //биология епта строки нуклеотидов в биты
        for (int i = 0; i < length; i++){
            final int firstLocation = 2 * i;
            final int secondLocation = 2 * i + 1;
            switch (upperGene.charAt(i)){
                case 'A': //00 - следующие два бита
                    bitSet.set(firstLocation,false);
                    bitSet.set(secondLocation,false);
                    break;
                case 'C': //01 - следующие два бита
                    bitSet.set(firstLocation,false);
                    bitSet.set(secondLocation,true);
                    break;
                case 'G': //10 - следующие два бита
                    bitSet.set(firstLocation, true);
                    bitSet.set(secondLocation,false);
                    break;
                case 'T': //11 - следующие два бита
                    bitSet.set(firstLocation,true);
                    bitSet.set(secondLocation,true);
                    break;
                default:
                    throw new IllegalArgumentException("The provided gene String contains characters other than ACGT");
            }
        }
    }

    public String decompress(){
        if (bitSet == null){
            return "";
        }
        // создание извеняемой позиции для символов в правильном порядке
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < (length * 2); i +=2){
            final int firstBit = (bitSet.get(i) ? 1 : 0 );
            final int secondBit = (bitSet.get(i + 1) ? 1 : 0);
            final int lastBits = firstBit << 1 | secondBit;
            switch (lastBits){
                case 0b00: // 00 = 'A'
                    builder.append('A');
                    break;
                case 0b01: //01 = 'B'
                    builder.append('C');
                    break;
                case 0b10: //10 = 'C'
                    builder.append('G');
                    break;
                case 0b11: //11 = 'T'
                    builder.append('T');
                    break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        final String original = "TAGGAGTAGAGATATATATGGAGAGAGATATATATGAGAGACCCCATCATCATCATCATCATCTATACTTCAGTCACGT";
        CompressedGene compressed = new CompressedGene(original);
        final String decompressed = compressed.decompress();
        System.out.println(decompressed);
        System.out.println("Original is the same as decompressed: " + original.equalsIgnoreCase(decompressed));
    }
}
