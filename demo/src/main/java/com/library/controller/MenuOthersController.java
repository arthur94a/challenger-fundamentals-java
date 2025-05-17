package com.library.controller;

import java.util.Scanner;

import com.library.util.LibraryMessages;

public class MenuOthersController {

    private void showMenu() {
        LibraryMessages.menu("title", "Outros");
        LibraryMessages.menu("option", "[1] - Adicionar um livro");
        LibraryMessages.menu("last-option", "[2] - Voltar");
    }

    public void handleMenuOthers(Scanner scanner) {
        boolean running = true;

        while (running) {
            showMenu();
            LibraryMessages.msg("Escolha o número da ação desejada: ");

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        LibraryMessages.msg("Novo livro - funcionalidade em desenvolvimento...");
                        break;

                    case 2:
                        running = false;
                        break;

                    default:
                        LibraryMessages.msg("Opção inválida. Escolha 1 ou 2.");
                }
            } else {
                LibraryMessages.msg("Valor inválido.");
                scanner.next();
            }
        }
    }
}
