package com.ghulam.store.services;

import com.ghulam.store.enums.Genre;
import com.ghulam.store.models.Book;

import java.util.List;

public interface BookService {

    // CRUD ops
    Book create(Book book);

    Book read(String bookId);

    Book update(String bookId, Book book);

    void delete(String bookId);

    List<Book> getAllBooks();


    // Search ops

    List<Book> searchByTitle(String title);

    List<Book> searchByAuthor(String author);

    List<Book> searchByGenre(Genre genre);

    List<Book> searchByPublisher(String publisher);

    Book searchByIsbn(String isbn);
}
