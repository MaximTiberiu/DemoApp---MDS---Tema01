package com.tiberiumaxim.demoaplicatietema01.repository;

import com.tiberiumaxim.demoaplicatietema01.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
