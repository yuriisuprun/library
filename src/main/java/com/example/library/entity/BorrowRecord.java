package com.example.library.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Yurii_Suprun
 */
@Data
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId; // foreign key to User
    private long bookId; // foreign key to Book
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate borrowDate;
    private LocalDate dueDate;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate returnDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
}
