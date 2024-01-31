package spring.library.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.dto.BookDto;
import spring.library.dto.MemberDto;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class BookListResponse{
    private List<BookResponse> books;
    public BookListResponse(List<BookDto> bookDtos) {
        this.books = bookDtos.stream().map(BookResponse::toBookResponse).toList();
    }
}