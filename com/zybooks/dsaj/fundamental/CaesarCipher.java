package com.zybooks.dsaj.fundamental;

import java.util.Arrays;

/** Class for doing encryption and decryption using the Caesar Cipher. */
public class CaesarCipher {
    protected char[] encoder = new char[26];              // Encryption array
    protected char[] decoder = new char[26];              // Decryption array

    /**
     * Constructor that initializes the encryption and decryption arrays.
     * @param rotation  the amount of forward shift
     */
    public CaesarCipher(int rotation) {
        for (int k=0; k < 26; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
        }
    }

    /**
     * Returns an encrypted version of an original message.
     * @param message the original message
     * @return the encrypted message
     */
    public String encrypt(String message) {
        return transform(message, encoder);               // use encoder array
    }

    /**
     * Returns a decrypted message, given the encrypted secret.
     * @param secret the encrypted message
     * @return the original (unencrypted) message
     */
    public String decrypt(String secret) {
        return transform(secret, decoder);                // use decoder array
    }

    /**
     * Returns transformation of original String using given code.
     * @param original the original message
     * @param code an array of 26 characters designating the replacement code for the alphabet
     * @return the encoded message
     */
    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int k=0; k < msg.length; k++)
            if (Character.isUpperCase(msg[k])) {          // we have a letter to change
                int j = msg[k] - 'A';                     // will be value from 0 to 25
                msg[k] = code[j];                         // replace the character
            }
        return new String(msg);
    }

    /** Simple main method for testing the Caesar cipher */
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String coded = cipher.encrypt(message);
        System.out.println("Secret:  " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);         // should be plaintext again
    }
}
