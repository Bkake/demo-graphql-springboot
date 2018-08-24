package com.example.demographqlspringboot.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demographqlspringboot.domain.Author;
import com.example.demographqlspringboot.domain.Book;
import com.example.demographqlspringboot.exception.BookNotFoundException;
import com.example.demographqlspringboot.repository.AuthorRepository;
import com.example.demographqlspringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return authorRepository.save(author);
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(authorRepository.findOne(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);
        return bookRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was found", id);
        }
        book.setPageCount(pageCount);
        return  bookRepository.save(book);
    }
}
