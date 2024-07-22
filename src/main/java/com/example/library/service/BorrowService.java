package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.BorrowRecord;
import com.example.library.entity.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowRecordRepository;
import com.example.library.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Yurii_Suprun
 */
@Service
public class BorrowService {
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public BorrowRecord borrowBook(Long userId, Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isEmpty() || !bookOptional.get().isAvailable()) {
            throw new RuntimeException("Book is not available for borrowing");
        }

        Book book = bookOptional.get();
        book.setAvailable(false);
        bookRepository.save(book);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setUserId(user.getId());
        borrowRecord.setBookId(book.getId());
        borrowRecord.setBorrowDate(LocalDate.now());

        return borrowRecordRepository.save(borrowRecord);
    }

    @Transactional
    public BorrowRecord returnBook(Long borrowRecordId) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(borrowRecordId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        Book book = borrowRecord.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        borrowRecord.setReturnDate(LocalDate.now().plusDays(7));
        return borrowRecordRepository.save(borrowRecord);
    }

    public List<BorrowRecord> getBorrowedBooks(Long userId) {
        return borrowRecordRepository.findByUserId(userId);
    }
}
