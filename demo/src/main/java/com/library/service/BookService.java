package com.library.service;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

import com.library.models.Author;
import com.library.models.Book;
import com.library.util.StringToInt;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> getAll() {
        return books;
    }

    public void newBook(AuthorService authors) {
        Scanner scanner = new Scanner(System.in);
        /*****************************************/
        System.out.print("Nome de livro ");
        String bookTitle = scanner.nextLine();
        System.out.println("Nome do livro: " + bookTitle);

        /*****************************************/
        System.out.println("Selecione um autor: ");
        int intAuthorId = -1;
        for (Author author : authors.getAll()) {
            String author_id = author.getId();
            String author_name = author.getName();
            intAuthorId = StringToInt.parse(author_id);
            System.out.println("- " + author_id  +  " - " + author_name);
        }

        boolean validAuthorId = false;
        Author author = null;
        while (!validAuthorId) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();

                if (input <= intAuthorId) {
                    System.out.println("é um numero valido");
                    validAuthorId = true;
                    author = authors.getById(String.valueOf(input));
                } else {
                    System.out.println("O número deve ser menor que " + intAuthorId);
                    scanner.next();
                }
            } else {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next();
            }
        }
        System.out.println("Autor:" + author);


        /*****************************************/
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
