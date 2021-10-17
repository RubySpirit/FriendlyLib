package com.spirituspoland.friendlylib.controller;

import com.spirituspoland.friendlylib.model.Book;
import com.spirituspoland.friendlylib.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }
}
