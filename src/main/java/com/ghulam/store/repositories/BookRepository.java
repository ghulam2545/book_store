package com.ghulam.store.repositories;

import com.ghulam.store.enums.Genre;
import com.ghulam.store.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByTitleContainsIgnoreCase(String title);

    List<Book> findByAuthorsContainsIgnoreCase(String author);

    List<Book> findByGenre(Genre genre);

    List<Book> findByPublisherContainsIgnoreCase(String publisher);

    Optional<Book> findByIsbn(String isbn);
}
