package com.example;

public class Encoder {
    private ReferenceTable table = new ReferenceTable();

    private int calculateOffset(char offsetChar) {
        int offset = table.getIndexOfChar(offsetChar);
        if (offset == -1) {
            throw new InvalidOffsetException("Invalid offset character: " + offsetChar);
        }
        return offset;
    }

    public String encode(String plainText, char offsetChar) {
        if (plainText == null || plainText.isEmpty()) {
            return "";
        }

        int offset = calculateOffset(offsetChar);

        StringBuilder encoded = new StringBuilder();
        encoded.append(offsetChar);  

        for (char c : plainText.toCharArray()) {
            encoded.append(table.getShiftedChar(c, offset));
        }

        return encoded.toString();
    }
    
    public String decode(String encodedText) {
        if (encodedText == null || encodedText.isEmpty()) {
            return "";
        }

        char offsetChar = encodedText.charAt(0);
        int offset = calculateOffset(offsetChar);

        StringBuilder decoded = new StringBuilder();

        for (int i = 1; i < encodedText.length(); i++) {
            decoded.append(table.getUnshiftedChar(encodedText.charAt(i), offset));
        }

        return decoded.toString();
    }
}
