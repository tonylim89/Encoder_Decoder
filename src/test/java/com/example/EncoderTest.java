package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EncoderTest {

    private Encoder encoder;

    @BeforeEach
    public void setup() {
        encoder = new Encoder();
    }

    @Test
    public void testEncodeWithValidOffset() {
        String encoded = encoder.encode("HELLO WORLD", 'B');
        assertEquals("BGDKKN VNQKC", encoded);
    }

    @Test
    public void testDecodeWithValidOffset() {
        String decoded = encoder.decode("BGDKKN VNQKC");
        assertEquals("HELLO WORLD", decoded);
    }

    @Test
    public void testEncodeDecodeIntegrity() {
        String original = generateRandomString(100); // Generate a string of length 100
        char randomOffset = generateRandomOffsetChar();
        String encoded = encoder.encode(original, randomOffset);
        String decoded = encoder.decode(encoded);
        assertEquals(original, decoded);
    }
    
    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
        StringBuilder result = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }
    
    private char generateRandomOffsetChar() {
        String validOffsets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
        Random random = new Random();
        return validOffsets.charAt(random.nextInt(validOffsets.length()));
    }
    

    @Test
    public void testInvalidOffset() {
        assertThrows(InvalidOffsetException.class, () -> {
            encoder.encode("HELLO WORLD", '#');
        });
    }
}