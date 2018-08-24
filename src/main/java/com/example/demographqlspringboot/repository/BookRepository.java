package com.example.demographqlspringboot.repository;

import com.example.demographqlspringboot.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
