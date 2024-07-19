package com.example.library.service;

import com.example.library.entity.BorrowRecord;
import com.example.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yurii_Suprun
 */
@Service
public class BorrowService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

//    public BorrowRecord borrowBook(Long userId, Long bookId) {
//        // Borrowing logic
//    }
//
//    public BorrowRecord returnBook(Long borrowRecordId) {
//        // Returning logic
//    }

    public List<BorrowRecord> getBorrowedBooks(Long userId) {
        return borrowRecordRepository.findByUserId(userId);
    }
}
