package com.library.util;

public class LibraryMessages {
    private static void boldLine() {
        System.out.println("==================================");
    }

    private static void line() {
        System.out.println("----------------------------------");
    }

    private static void end() {
        System.out.println("\n");
    }

    public static void msg(String message) {
        System.out.println(message + "\n");
    }

    public static void name() {
        boldLine();
        System.out.println("         Library System");
        boldLine();
        end();
    }

    public static void menu(String type, String option) {
        switch (type) {
            case "title":
                boldLine();
                System.out.println("MENU");
                boldLine();
                break;
            case "option":
                System.out.println(option);
                line();
                break;
            case "last-option":
                System.out.println(option);
                boldLine();
                end();
                break;
            default:
                break;
        }
    }

}
