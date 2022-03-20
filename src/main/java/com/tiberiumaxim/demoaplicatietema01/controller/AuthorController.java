package com.tiberiumaxim.demoaplicatietema01.controller;

import com.tiberiumaxim.demoaplicatietema01.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/api/v1/Author/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
