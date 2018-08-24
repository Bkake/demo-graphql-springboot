package com.example.demographqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demographqlspringboot.domain.Author;
import com.example.demographqlspringboot.domain.Book;
import com.example.demographqlspringboot.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    @Autowired
    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());

    }
}
