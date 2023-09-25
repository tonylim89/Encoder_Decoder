package com.example;

public class App {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        String plainText = "HELLO WORLD";

        try {
            String encoded = encoder.encode(plainText, 'F'); // You can change this character to test the exception
            System.out.println("Encoded: " + encoded);

            String decoded = encoder.decode(encoded);
            System.out.println("Decoded: " + decoded);
        } catch (InvalidOffsetException e) {
            System.err.println(e.getMessage());
        }
    }
}