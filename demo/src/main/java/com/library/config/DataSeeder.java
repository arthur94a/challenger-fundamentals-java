package com.library.config;

import java.time.LocalDate;

import com.library.models.Author;
import com.library.models.Book;
import com.library.service.AuthorService;
import com.library.service.BookService;

public class DataSeeder {
    public static void seed(BookService bookService, AuthorService authorService) {
        /*************
        * Authors
        **************/
        Author machadoDeAssis = new Author("Machado de Assis", LocalDate.of(1839, 6, 21));
        Author gabrielGarciaMarquez = new Author("Gabriel García Márquez", LocalDate.of(1927, 3, 6));
        Author georgeOrwell = new Author("George Orwell", LocalDate.of(1903, 6, 25));
        Author jRRTolkien = new Author("J.R.R. Tolkien", LocalDate.of(1892,1,3));
        Author antoineDeSaintExupery = new Author("Antoine de Saint-Exupéry", LocalDate.of(1900, 6, 29));
        Author janeAusten = new Author("Jane Austen", LocalDate.of(1775,12, 16));
        Author joaoGuimaraesRosa = new Author("João Guimarães Rosa", LocalDate.of(1908, 6, 27));
        Author jDSalinger = new Author("J.D. Salinger", LocalDate.of(1919, 1, 1));
        Author franzKafka = new Author("Franz Kafka", LocalDate.of(1883, 7, 3));

        authorService.add(machadoDeAssis);
        authorService.add(gabrielGarciaMarquez);
        authorService.add(georgeOrwell);
        authorService.add(jRRTolkien);
        authorService.add(antoineDeSaintExupery);
        authorService.add(janeAusten);
        authorService.add(joaoGuimaraesRosa);
        authorService.add(jDSalinger);
        authorService.add(franzKafka);

        /*************
        * Books 
        **************/
        bookService.add(new Book("Dom Casmurro", machadoDeAssis, 1899));
        bookService.add(new Book("Cem anos de solidão", gabrielGarciaMarquez, 1967));
        bookService.add(new Book("1984", georgeOrwell, 1949));
        bookService.add(new Book("O Senhor dos aneis: A sociedade do anel", jRRTolkien, 1954));
        bookService.add(new Book("O Hobbit", jRRTolkien, 1937));
        bookService.add(new Book("O pequeno príncipe", antoineDeSaintExupery, 1943));
        bookService.add(new Book("Jane Austen", janeAusten, 1813));
        bookService.add(new Book("O Apanhador no Campo de Centeio", jDSalinger, 1951));
        bookService.add(new Book("A Metamorfose", franzKafka, 1915));
        bookService.add(new Book("A Revolução dos Bichos", georgeOrwell, 1945));
        bookService.add(new Book("Grande Sertão: Veredas", joaoGuimaraesRosa, 1956));
    }
}
