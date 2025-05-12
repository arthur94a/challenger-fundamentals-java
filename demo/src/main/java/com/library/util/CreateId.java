package com.library.util;

public class CreateId {
    private static long idCounter = 0;
    private static long idAuthorCounter = 0;

    public static synchronized String add()
    {
        return String.valueOf(idCounter++);
    }

    public static synchronized String addAuthor()
    {
        return String.valueOf(idAuthorCounter++);
    } 
}
