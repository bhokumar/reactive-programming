package com.smarttech.reactive.programming.services;

import com.smarttech.reactive.programming.domain.BookInfo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BookInfoService {
    public Flux<BookInfo> getBooks() {
        var books = List.of(
                new BookInfo(1, "Book One", "Author One", "123123"),
                new BookInfo(2, "Book Two", "Author Two", "127823"),
                new BookInfo(3, "Book Three", "Author Three", "125613")
        );

        return Flux.fromIterable(books);
    }

    public Mono<BookInfo> getBookById(long bookId) {
        var book = new BookInfo(1, "Book One", "Author One", "123123");
        return  Mono.just(book);
    }
}
