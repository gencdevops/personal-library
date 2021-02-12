package dev.milikkan.personallibrary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subtitle;
    private String series;
    private String isbn;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "authorId"))
    private List<Author> authors = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Publisher publisher;

    private String explanation;

    public Book(Long id, String title, String subtitle, String series, String isbn, Publisher publisher, String explanation) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.series = series;
        this.isbn = isbn;
        this.publisher = publisher;
        this.explanation = explanation;
    }
}