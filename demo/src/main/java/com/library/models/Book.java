package com.library.models;

import java.time.LocalDate;

import com.library.util.CreateId;

public class Book {
    /*************************************************************************
    *   id:                Identificador único do livro
    *   titulo:            Título do livro
    *   autor:             Autor do livro (objeto do tipo Autor)
    *   Publicação:        Ano de publicação do livro
    *   disponivel:        Indica se o livro está disponível para empréstimo
    *   dataCadastro:      Data que o livro foi cadastrado
    *   dataAtualização:   Data que o livro foi atualizado
    **************************************************************************/

    private String id = CreateId.add();;
    private String title;
    private Author author;
    private int publish;
    private boolean available;
    private LocalDate registerDate = LocalDate.now();
    private LocalDate attDate = LocalDate.now();

    public Book(String title, Author author, int publish) {
        this.title = title;
        this.author = author;
        this.publish = publish;
        this.available = false;
    }

    /****************
    *   GETTERS 
    *****************/

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPublish() {
        return publish;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public LocalDate getAttDate() {
        return attDate;
    }

    /****************
    *   SETTERS 
    *****************/

    public void setAvailable(boolean available) {
        this.available = available;
        this.attDate = LocalDate.now();
    }

    public void setAttDate(LocalDate attDate) {
        this.attDate = attDate;
    }

    /****************
    *   METODS 
    *****************/

    public String printBook() {
        return "Book{" +
               "id='" + id + '\'' +
               ", title='" + title + '\'' +
               ", author=" + author.getName() +
               ", publish=" + publish +
               ", available=" + available +
               ", registerDate=" + registerDate +
               ", attDate=" + attDate +
               '}';
    }
} 
