package com.library.service;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.library.models.Author;
import com.library.models.Book;
import com.library.util.CapitalizeString;
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
        System.out.print("Nome de livro: ");
        String bookTitle = CapitalizeString.firstLetter(scanner.nextLine());

        /*****************************************/
        System.out.println("\nSelecione um autor: ");
        int intAuthorId = -1;
        for (Author author : authors.getAll()) {
            String author_id = author.getId();
            String author_name = author.getName();
            intAuthorId = StringToInt.parse(author_id);
            System.out.println("- " + author_id  +  " - " + author_name);
        }
        System.out.print("\nDigite o número do autor: ");

        boolean validAuthorId = false;
        Author author = null;
        while (!validAuthorId) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();

                if (input <= intAuthorId) {
                    System.out.println("é um numero valido\n");
                    validAuthorId = true;
                    author = authors.getById(String.valueOf(input));
                } else {
                    System.out.println("O número deve ser menor que " + intAuthorId + "\n");
                    scanner.next();
                }
            } else {
                System.out.println("Por favor, digite um número inteiro válido.\n");
                scanner.next();
            }
        }
        System.out.println("Autor:" + author.getName() + "\n");

        /*****************************************/
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int bookPublishYear = 0;
        boolean validYear = false;

        while (!validYear) {
            System.out.print("\nAno de publicação: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                
                if (String.valueOf(input).length() == 4 && input <= year) {
                    bookPublishYear = input;
                    validYear = true;
                } else if(input > year) {
                    System.out.println("O ano não deve ser maior que o ano vigente.");
                } else {
                    System.out.println("O ano deve conter 4 dígitos. Exemplo: 2001.");
                }
            } else {
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next();
            }
        }
        scanner.close();

        if (bookTitle != null && author != null && bookPublishYear != 0) {
            books.add(new Book(bookTitle, author, bookPublishYear));
            System.out.println("Livro adicionado a lista!");
        } else {
            System.out.println("Erro ao adicionar novo livro");
        }
    }
}
