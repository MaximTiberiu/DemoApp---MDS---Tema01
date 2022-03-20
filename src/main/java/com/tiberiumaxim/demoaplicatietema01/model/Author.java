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
public class Author {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @NotNull
    private String firstName;

    @Getter
    @Setter
    @NotNull
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    @Getter
    @Setter
    @ToString.Exclude
    private Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;

        Author author = (Author) o;

        return id != null && Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
