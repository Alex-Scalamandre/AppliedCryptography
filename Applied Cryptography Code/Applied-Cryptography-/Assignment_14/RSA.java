package Assignment_14;

import java.math.BigInteger;

public class RSA{ 

    public static void encrypt(){
        BigInteger n, e, cipherOne, cipherTwo, cipherText, one, two;
        n = new BigInteger("712446816787");
        e = new BigInteger("6551");

        // Text code of possible plaintexts.
        one = new BigInteger("151405"); // One
        two = new BigInteger("202315"); // Two

        // Ciphertext initialization.
        cipherText = new BigInteger("273095689186");
        System.out.println("The ciphertext is equal to: " + cipherText);

        // Calculate ciphertext of One and Two
        cipherOne = one.modPow(e, n);
        System.out.println("The ciphertext of One is: " + cipherOne);
        cipherTwo = two.modPow(e, n);
        System.out.println("The ciphertext of Two is: " + cipherTwo);

        // Compare the ciphertext of One and Two with the given ciphertext.
        if(cipherOne.compareTo(cipherText) == 0){
            System.out.println("The plaintext was One!");
        }else{
            System.out.println("The plaintext was Two!");
        }
    }

    public static void main(String[] args){
        encrypt();
    }
}