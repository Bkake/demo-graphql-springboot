package com.example.demographqlspringboot.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Author {
    @Id
    @Column(name = "author_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author_first_name", nullable = false)
    private String firstName;

    @Column(name = "author_last_name", nullable = false)
    private String lastName;
}
