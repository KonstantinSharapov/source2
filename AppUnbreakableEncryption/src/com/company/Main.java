package com.company;

public class Main {

    public static void main(String[] args) {
        UnbreakableEncryption unbreakableEncryption = new UnbreakableEncryption();
        KeyPair keyPair = unbreakableEncryption.encrypt("One Time Pad!");
        String result = unbreakableEncryption.decrypt(keyPair);
        System.out.println(result);
    }
}
