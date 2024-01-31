package spring.library.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import spring.library.domain.Book;
import spring.library.dto.BookDto;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class BookResponse {

    private Long bookId;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String classification;
    private String status;

    public static BookResponse toBookResponse (BookDto bookDto) {
        return BookResponse.builder()
                .bookId(bookDto.getBookId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publisher(bookDto.getPublisher())
                .publicationYear(bookDto.getPublicationYear())
                .classification(bookDto.getClassification())
                .status(bookDto.getStatus())
                .build();
    }
}
