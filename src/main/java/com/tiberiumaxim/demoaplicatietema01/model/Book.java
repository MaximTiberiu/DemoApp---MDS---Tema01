package com.tiberiumaxim.demoaplicatietema01.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
public class Book {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @NotNull
    private String title;

    @Getter
    @Setter
    @NotNull
    private String isbn;

    @Getter
    @Setter
    @NotNull
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    private Publisher publisher;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;

        Book book = (Book) o;

        return id != null && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
