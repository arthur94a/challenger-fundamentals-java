package com.library;

import java.util.ArrayList;
import java.util.List;

import com.library.config.DataSeeder;
import com.library.models.Author;
import com.library.models.Book;
import com.library.models.Lend;
// import com.library.models.User;
import com.library.service.AuthorService;
import com.library.service.BookService;

public class Main {
    public List<Author> authors = new ArrayList<>();
    public List<Lend> lends = new ArrayList<>();
    public static void main(String[] args) {
        BookService books = new BookService();
        AuthorService authors = new AuthorService();

        DataSeeder.seed(books, authors);

        System.out.println("---------------------");
        System.out.println("Livros na biblioteca:\n");
        for (Book book: books.getAll()) {
            System.out.println(book.getTitle());
        }

        System.out.println("---------------------");
        System.out.println("Adicionando um livro:\n");
        books.newBook(authors);

        System.out.println("---------------------");
        System.out.println("Nova lista de livros:\n");
        for (Book book: books.getAll()) {
            System.out.println(book.getTitle());
        }
    }
}