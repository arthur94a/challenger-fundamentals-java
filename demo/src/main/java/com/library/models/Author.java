package com.library.models;

import java.time.LocalDate;

import com.library.util.CreateId;

public class Author {
    /***************************************************
    * - id:                Identificador único do autor
    * - nome:              Nome do autor
    * - dataNascimento:    Nascimento do autor
    ****************************************************/

    String id = CreateId.addAuthor();
    String name;
    LocalDate bornDate;

    public Author(String name, LocalDate borDate) {
        this.name = name;
        this.bornDate = borDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }
}
