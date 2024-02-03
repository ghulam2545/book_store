package com.ghulam.store.models;

import com.ghulam.store.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_book")
public class Book implements Serializable {

    @Id
    @Column(name = "book_id", nullable = false, unique = true)
    private String bookId;

    @Column(name = "title", nullable = false)
    private String title;

    @ElementCollection
    @CollectionTable(name = "tb_book_authors", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "author", nullable = false)
    private Set<String> authors;

    @Column(name = "description", nullable = true)
    private String description;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "genre", nullable = true)
    private Genre genre;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "publisher", nullable = true)
    private String publisher;

    @Column(name = "price", nullable = false)
    private long price;

}
