package com.tiberiumaxim.demoaplicatietema01.controller;

import com.tiberiumaxim.demoaplicatietema01.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/api/v1/Book/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}
