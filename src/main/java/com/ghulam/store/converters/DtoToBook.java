package com.ghulam.store.converters;

import com.ghulam.store.dtos.request.BookRequestDto;
import com.ghulam.store.models.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToBook implements Converter<BookRequestDto, Book> {
    @Override
    public Book convert(BookRequestDto source) {
        Book book = new Book();

        book.setTitle(source.title());
        book.setAuthors(source.authors());
        book.setDescription(source.description());
        book.setGenre(source.genre());
        book.setIsbn(source.Isbn());
        book.setPublisher(source.publisher());
        book.setPrice(source.price());

        return book;
    }
}
