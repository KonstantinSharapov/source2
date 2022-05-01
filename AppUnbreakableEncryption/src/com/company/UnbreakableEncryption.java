package com.company;

import java.util.Random;

public class UnbreakableEncryption {
    //генерировать length лучайных байтов
    private byte[] randomKey(int length){
        byte[] dummy = new byte[length];
        Random random = new Random();
        random.nextBytes(dummy);
        return dummy;
    }

    public KeyPair encrypt(String original){
        byte[] originalBytes = original.getBytes();
        byte[] dummyKey = randomKey(originalBytes.length);
        byte[] encryptedKey = new byte[originalBytes.length];
        for (int i = 0; i < originalBytes.length; i++){
            //Побитовое операция XOR
            encryptedKey[i] = (byte) (originalBytes[i] ^ dummyKey[i]);
        }
        return new KeyPair(dummyKey,encryptedKey);
    }

    public String decrypt(KeyPair kp){
        byte[] decrypted = new byte[kp.key1.length];
        for (int i = 0; i < kp.key1.length; i++){
            //Побитовое операция XOR
            decrypted[i] = (byte) (kp.key1[i] ^ kp.key2[i]);
        }
        return new String(decrypted);
    }
}
