package spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.form.BookForm;
import spring.library.controller.response.BookListResponse;
import spring.library.dto.BookDto;
import spring.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {

    private final BookService bookService;

    //추가
    @PostMapping
    public ResponseEntity<Void> addBook(@RequestBody BookForm form) {
        Long bookId = bookService.addBook(BookDto.from(form));
        return ResponseEntity.ok(null);
    }

    //수정
    @PutMapping("/{bookId}")
    public ResponseEntity<Void> editBook(@PathVariable Long bookId, @RequestBody BookForm form){
        Long newBookId = bookService.editBook(bookId, BookDto.from(form));
        return ResponseEntity.ok(null);
    }

    //목록보기
    @GetMapping
    public ResponseEntity<BookListResponse> getAllBook(){
        List<BookDto> bookDtos = bookService.getAllBooks();
        BookListResponse response = new BookListResponse(bookDtos);
        return ResponseEntity.ok(response);
    }

    //삭제
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.ok(null);
    }
}
