package com.finalproject.librolead.author.repository;

import com.finalproject.librolead.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
