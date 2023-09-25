package com.example;

public class ReferenceTable {
    final String table = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

    public char getShiftedChar(char c, int offset) {
        int index = table.indexOf(c);
        if (index == -1) {
            return c;
        }
        
        int shiftedIndex = (index - offset + table.length()) % table.length(); 
        return table.charAt(shiftedIndex);
    }
    
    public char getUnshiftedChar(char c, int offset) {
        int index = table.indexOf(c);
        if (index == -1) {
            return c;  
        }
    
        int unshiftedIndex = (index + offset) % table.length();  
    
        return table.charAt(unshiftedIndex);
    }
    

    public int getIndexOfChar(char c) {
        return table.indexOf(c);
    }    
}