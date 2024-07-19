package com.example.library.controller;

import com.example.library.entity.BorrowRecord;
import com.example.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yurii_Suprun
 */
@RestController
@RequestMapping("/api/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public ResponseEntity<BorrowRecord> borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        BorrowRecord borrowRecord = borrowService.borrowBook(userId, bookId);
        return ResponseEntity.ok(borrowRecord);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<BorrowRecord> returnBook(@PathVariable Long id) {
        BorrowRecord borrowRecord = borrowService.returnBook(id);
        return ResponseEntity.ok(borrowRecord);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowRecord>> getBorrowedBooks(@PathVariable Long userId) {
        List<BorrowRecord> borrowRecords = borrowService.getBorrowedBooks(userId);
        return ResponseEntity.ok(borrowRecords);
    }
}

