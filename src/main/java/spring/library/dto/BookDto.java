package spring.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.controller.form.BookForm;
import spring.library.domain.Book;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long bookId;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String classification;
    private String status;

    public static BookDto from(Book book) {
        return BookDto.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .publicationYear(book.getPublicationYear())
                .classification(book.getClassification())
                .status(book.getStatus())
                .build();
    }

    public static BookDto from(BookForm bookform) {
        return BookDto.builder()
                .title(bookform.getTitle())
                .author(bookform.getAuthor())
                .publisher(bookform.getPublisher())
                .publicationYear(bookform.getPublicationYear())
                .classification(bookform.getClassification())
                .build();
    }
}
