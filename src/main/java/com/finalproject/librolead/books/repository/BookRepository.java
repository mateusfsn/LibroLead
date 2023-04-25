package com.finalproject.librolead.books.repository;

import com.finalproject.librolead.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
