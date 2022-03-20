package com.tiberiumaxim.demoaplicatietema01.bootstrap;

import com.tiberiumaxim.demoaplicatietema01.model.Author;
import com.tiberiumaxim.demoaplicatietema01.model.Book;
import com.tiberiumaxim.demoaplicatietema01.model.Publisher;
import com.tiberiumaxim.demoaplicatietema01.repository.AuthorRepository;
import com.tiberiumaxim.demoaplicatietema01.repository.BookRepository;
import com.tiberiumaxim.demoaplicatietema01.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher("Editura Casa Cartii", "Str. Bucuresti, nr. 2",
                "Bucuresti", "123456789", "casa@cartii.ro");
        Publisher publisher2 = new Publisher("Editura Cartos", "Bd. Elisabeta, nr. 75",
                "Timisoara", "987654321", "contact@cartos.ro");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        Author author1 = new Author("Andrei", "Popescu");
        Author author2 = new Author("Maria", "Georgescu");

        Book book1 = new Book("Analiza Matematica pentru Clasa a XII-a", "398398");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        publisher1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);

        Book book2  = new Book("Alegebra si Geometrie pentru Studenti", "396145");
        author1.getBooks().add(book2);
        author2.getBooks().add(book2);
        book2.getAuthors().add(author1);
        book2.getAuthors().add(author2);
        publisher2.getBooks().add(book2);

        authorRepository.save(author1);
        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher2);

        Book book3 = new Book("Matematici Speciale - Integrale Duble si Triple", "152986");
        author1.getBooks().add(book3);
        book3.getAuthors().add(author1);
        publisher1.getBooks().add(book3);

        authorRepository.save(author1);
        bookRepository.save(book3);
        publisherRepository.save(publisher1);
    }
}
