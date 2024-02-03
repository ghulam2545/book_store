package com.ghulam.store.services.impl;

import com.ghulam.store.enums.Genre;
import com.ghulam.store.exceptions.BookNotFoundException;
import com.ghulam.store.models.Book;
import com.ghulam.store.repositories.BookRepository;
import com.ghulam.store.services.BookService;
import com.ghulam.store.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    @Override
    public Book create(Book book) {
        final String id = IdGenerator.next();
        book.setBookId(id);

        return bookRepo.save(book);
    }

    @Override
    public Book read(String bookId) {
        return bookRepo.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book of id: " + bookId + " is not found."));
    }

    @Override
    public Book update(String bookId, Book book) {
        Book oldBook = bookRepo.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book of id: " + bookId + " is not found."));

        // update old book data
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthors(book.getAuthors());
        oldBook.setDescription(book.getDescription());
        oldBook.setGenre(book.getGenre());
        oldBook.setIsbn(book.getIsbn());
        oldBook.setPublisher(book.getPublisher());
        oldBook.setPrice(book.getPrice());

        return bookRepo.save(oldBook);
    }

    @Override
    public void delete(String bookId) {
        boolean b = bookRepo.existsById(bookId);

        if (b) {
            bookRepo.deleteById(bookId);
        } else {
            throw new BookNotFoundException("Book of id: " + bookId + " is not found.");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepo.findByTitleContainsIgnoreCase(title);
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return bookRepo.findByAuthorsContainsIgnoreCase(author);
    }

    @Override
    public List<Book> searchByGenre(Genre genre) {
        return bookRepo.findByGenre(genre);
    }

    @Override
    public List<Book> searchByPublisher(String publisher) {
        return bookRepo.findByPublisherContainsIgnoreCase(publisher);
    }

    @Override
    public Book searchByIsbn(String isbn) {
        return bookRepo.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book of ISBN: " + isbn + " is not found."));
    }
}
