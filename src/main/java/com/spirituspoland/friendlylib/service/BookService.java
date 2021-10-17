package com.spirituspoland.friendlylib.service;

import com.spirituspoland.friendlylib.model.Book;
import com.spirituspoland.friendlylib.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;


    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

}
