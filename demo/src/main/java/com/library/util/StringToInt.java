package com.library.util;

public class StringToInt {
    public static int parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println("Invalid string format. Cannot convert to integer.");
            return -1;
        }
    }
}
