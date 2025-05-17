package com.library;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import com.library.config.DataSeeder;
import com.library.controller.MenuOthersController;
import com.library.models.Author;
import com.library.models.Book;
import com.library.models.Lend;
// import com.library.models.User;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.util.LibraryMessages;

public class Main {
    public List<Author> authors = new ArrayList<>();
    public List<Lend> lends = new ArrayList<>();
    public static void main(String[] args) {
        BookService books = new BookService();
        AuthorService authors = new AuthorService();

        DataSeeder.seed(books, authors);
        boolean systemRunning = true;

        LibraryMessages.name();

        Scanner scMenu = new Scanner(System.in);
        int menuOptionsQnt = 4;
        boolean showMenu = true;

        while (systemRunning) {
            if (!showMenu) {
                LibraryMessages.msg("\nAbrir menu? s/n");
                char mustShowMenu = scMenu.next().charAt(0);

                switch (mustShowMenu) {
                    case 's':
                    case 'S':
                        showMenu = true;
                        break;
                    case 'n':
                    case 'N':
                        LibraryMessages.msg("\nFinalizar programa? (s/n)");
                        char wantClose = scMenu.next().charAt(0);
                        switch (wantClose) {
                            case 's':
                            case 'S':
                                systemRunning = false;
                                return;
                            default:
                                break;
                        }

                        break;
                    default:
                        LibraryMessages.msg("\nDigite (s) para sim, (n) para não.");
                        break;
                }
            }

            if (showMenu) {
                LibraryMessages.menu("title", null);
                LibraryMessages.menu("option", "[1] - Ver lista de livros na biblioteca");
                LibraryMessages.menu("option", "[2] - Reservar livro");
                LibraryMessages.menu("option", "[3] - Outros");
                LibraryMessages.menu("last-option", "[4] - Sair");

                LibraryMessages.msg("Escolha o número da ação desejada: ");
            }

            if (scMenu.hasNextInt()) {
                int menuOption = scMenu.nextInt();
                scMenu.nextLine();
                showMenu = false;

                switch (menuOption) {
                    case 1:
                        System.out.println("---------------------");
                        System.out.println("Livros na biblioteca:\n");
                        for (Book book : books.getAll()) {
                            System.out.println(book.getTitle());
                        }
                        break;

                    case 2:
                        System.out.println("---------------------");
                        System.out.println("Reservar um livro:");
                        books.newBook(authors);
                        break;
                    
                    case 3:
                        MenuOthersController menuOthers = new MenuOthersController();
                        menuOthers.handleMenuOthers(scMenu);
                        break;

                    case 4:
                        System.out.println("Saindo do sistema...");
                        break;

                    default:
                        LibraryMessages.msg("Escolha um valor entre 1 e " + menuOptionsQnt);
                }
            } else {
                LibraryMessages.msg("Valor inválido. Digite um número.");
                scMenu.next();
            }
        }
        scMenu.close();

        // System.out.println("---------------------");
        // System.out.println("Adicionando um livro:\n");
        // books.newBook(authors);
    }
}