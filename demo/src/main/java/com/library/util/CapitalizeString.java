package com.library.util;

public class CapitalizeString {
    public static String firstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char firstLetter = Character.toUpperCase(input.charAt(0));
        String restPhrase = input.substring(1).toLowerCase();

        return firstLetter + restPhrase;
    }
}
