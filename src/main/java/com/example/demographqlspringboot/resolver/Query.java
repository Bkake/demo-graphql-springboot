package com.example.demographqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demographqlspringboot.domain.Author;
import com.example.demographqlspringboot.domain.Book;
import com.example.demographqlspringboot.repository.AuthorRepository;
import com.example.demographqlspringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();

    }

    public Author findAuthorById(Long id) {
        return  authorRepository.findOne(id);
    }
}
