package spring.library.domain;

import jakarta.persistence.*;
import lombok.*;
import spring.library.dto.BookDto;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Member{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String classification;
    private String status;

    public static Book toBook(BookDto bookDto) {
        return Book.builder()
                .bookId(bookDto.getBookId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publisher(bookDto.getPublisher())
                .publicationYear(bookDto.getPublicationYear())
                .classification(bookDto.getClassification())
                .build();
    }

    public static Book toBook(BookDto bookDto, Long bookId) {
        return Book.builder()
                .bookId(bookId)
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publisher(bookDto.getPublisher())
                .publicationYear(bookDto.getPublicationYear())
                .classification(bookDto.getClassification())
                .build();
    }
}
