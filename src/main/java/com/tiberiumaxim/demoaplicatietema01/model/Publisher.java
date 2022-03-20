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
public class Publisher {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @NotNull
    private String name;

    @Getter
    @Setter
    @NotNull
    private String addressLine;

    @Getter
    @Setter
    @NotNull
    private String city;

    @Getter
    @Setter
    @NotNull
    private String phoneNumber;


    @Getter
    @Setter
    @NotNull
    private String emailAdress;

    @Getter
    @Setter
    @ToString.Exclude
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher(String name, String addressLine, String city, String phoneNumber, String emailAdress) {
        this.name = name;
        this.addressLine = addressLine;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;

        Publisher publisher = (Publisher) o;

        return id != null && Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
