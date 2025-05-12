package com.library.service;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

import com.library.models.Book;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> getAll() {
        return books;
    }

    public void newBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome de livro ");
        String bookTitle = scanner.nextLine();
        System.out.println("Nome do livro: " + bookTitle);

        System.out.print("Nome do autor: ");
        String bookAuthor = scanner.nextLine();
        System.out.println("Nome do autor: " + bookAuthor);

        System.out.print("Ano de publicação:");
        int bookPublishYear = 0;
        boolean validYear = false;

        while (!validYear) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (String.valueOf(input).length() == 4) {
                    bookPublishYear = input;
                    validYear = true;
                } else {
                    System.out.println("O ano deve conter 4 dígitos. Exemplo: 2001.");
                }
            } else {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next();
            }
        }
        System.out.println("Ano de publicação: " + bookPublishYear);
        scanner.close();
    }
}
