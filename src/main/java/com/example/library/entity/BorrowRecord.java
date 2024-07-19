package com.example.library.entity;

import java.time.LocalDate;

/**
 * @author Yurii_Suprun
 */
public class BorrowRecord {

    private long id;
    private long userId; // foreign key to User
    private long bookId; // foreign key to Book
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
}
