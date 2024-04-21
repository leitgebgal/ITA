package um.feri.ita.bookservice.vao;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Book {
    public Book() {}

    public Book(um.feri.ita.bookservice.dto.Book dto) {
        setTitle(dto.title());
        setAuthor(dto.author());
        setPublisher(dto.publisher());
        setPublicationYear(dto.publicationYear());
    }

    public void updateFrom(um.feri.ita.bookservice.dto.Book dto) {
        setTitle(dto.title());
        setAuthor(dto.author());
        setPublisher(dto.publisher());
        setPublicationYear(dto.publicationYear());
    }

    public um.feri.ita.bookservice.dto.Book toDto() {
        return new um.feri.ita.bookservice.dto.Book(
                getId(),
                getTitle(),
                getAuthor(),
                getPublisher(),
                getPublicationYear()
        );
    }

    @Id
    protected String id;

    protected String title;
    protected String author;
    protected String publisher;
    protected int publicationYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getPublicationYear() { return publicationYear; }

    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
