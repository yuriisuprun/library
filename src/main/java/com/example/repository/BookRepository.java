package com.example.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Yurii_Suprun
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByGenreContaining(String genre);
}