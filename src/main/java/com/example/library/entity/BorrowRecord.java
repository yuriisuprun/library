package com.example.library.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

/**
 * @author Yurii_Suprun
 */
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId; // foreign key to User
    private long bookId; // foreign key to Book
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
}
