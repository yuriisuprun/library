package com.example.library.entity;

import jakarta.persistence.Entity;

import java.time.LocalDate;

/**
 * @author Yurii_Suprun
 */
@Entity
public class Book {


    private long id;
    private String title;
    private String author;
    private String genre;
    private LocalDate publishedDate;
    private String isbn;
    private int availableCopies;
}
