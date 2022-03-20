package com.tiberiumaxim.demoaplicatietema01.repository;

import com.tiberiumaxim.demoaplicatietema01.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
