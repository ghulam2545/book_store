package com.ghulam.store.controllers;

import com.ghulam.store.converters.DtoToBook;
import com.ghulam.store.dtos.request.BookRequestDto;
import com.ghulam.store.enums.Genre;
import com.ghulam.store.models.Book;
import com.ghulam.store.services.BookService;
import com.ghulam.store.utils.Result;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoints.base-url}/books")
public class BookController {

    private final BookService bookService;
    private final DtoToBook dtoToBook;

    @PostMapping
    public Result addBook(@Valid @RequestBody BookRequestDto dto) {
        Book book = dtoToBook.convert(dto);
        Book addedBook = bookService.create(book);

        return new Result(true, HttpStatus.CREATED, "Book '" + addedBook.getTitle() + "' has been added successfully.", addedBook);
    }

    @GetMapping("/{bookId}")
    public Result getBook(@PathVariable String bookId) {
        Book book = bookService.read(bookId);

        return new Result(true, HttpStatus.OK, "Retrieved book details for book ID: " + bookId, book);
    }

    @PutMapping("/{bookId}")
    public Result updateBook(@PathVariable String bookId, @Valid @RequestBody BookRequestDto dto) {
        Book book = dtoToBook.convert(dto);
        Book updatedBook = bookService.update(bookId, book);

        return new Result(true, HttpStatus.OK, "Book '" + updatedBook.getTitle() + "' has been updated successfully.", updatedBook);
    }

    @DeleteMapping("/{bookId}")
    public Result deleteBook(@PathVariable String bookId) {
        bookService.delete(bookId);

        return new Result(true, HttpStatus.OK, "Book with ID: " + bookId + " has been deleted successfully.");
    }

    @GetMapping
    public Result getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return new Result(true, HttpStatus.OK, "Retrieved a list of all available books.", allBooks);
    }

    @GetMapping("/title/{title}")
    public Result searchTitle(@PathVariable String title) {
        List<Book> books = bookService.searchByTitle(title);

        return new Result(true, HttpStatus.OK, "Found books matching the title: " + title, books);
    }

    @GetMapping("/author/{author}")
    public Result searchAuthor(@PathVariable String author) {
        List<Book> books = bookService.searchByAuthor(author);
        log.info(author);

        return new Result(true, HttpStatus.OK, "Found books matching the author: " + author, books);
    }

    @GetMapping("/genre/{genre}")
    public Result searchGenre(@PathVariable Genre genre) {
        List<Book> books = bookService.searchByGenre(genre);

        return new Result(true, HttpStatus.OK, "Found books matching the genre: " + genre, books);
    }

    @GetMapping("/publisher/{publisher}")
    public Result searchPublisher(@PathVariable String publisher) {
        List<Book> books = bookService.searchByPublisher(publisher);

        return new Result(true, HttpStatus.OK, "Found books matching the publisher: " + publisher, books);
    }

    @GetMapping("/isbn/{isbn}")
    public Result searchIsbn(@PathVariable String isbn) {
        Book book = bookService.searchByIsbn(isbn);

        return new Result(true, HttpStatus.OK, "Found book matching the ISBN: " + isbn, book);
    }
}
