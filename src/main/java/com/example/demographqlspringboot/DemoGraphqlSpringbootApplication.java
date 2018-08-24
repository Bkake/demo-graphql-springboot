package com.example.demographqlspringboot;

import com.example.demographqlspringboot.domain.Author;
import com.example.demographqlspringboot.domain.Book;
import com.example.demographqlspringboot.exception.GraphQLErrorAdapter;
import com.example.demographqlspringboot.repository.AuthorRepository;
import com.example.demographqlspringboot.repository.BookRepository;
import com.example.demographqlspringboot.resolver.BookResolver;
import com.example.demographqlspringboot.resolver.Mutation;
import com.example.demographqlspringboot.resolver.Query;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import graphql.servlet.GraphQLErrorHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoGraphqlSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphqlSpringbootApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return (args) -> {
			Author author = new Author();
			author.setFirstName("KAKE");
			author.setLastName("Bangaly");
			authorRepository.save(author);

			Author author2 = new Author();
			author2.setFirstName("Conde");
			author2.setLastName("Lamaye");
			authorRepository.save(author2);

			bookRepository.save(new Book("GraphQL API Design", "0052902000", 240, author));
			bookRepository.save(new Book("Spring Boot 2", "1152902111", 40, author2));
		};
	}
}
