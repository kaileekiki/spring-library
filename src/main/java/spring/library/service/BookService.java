package spring.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.domain.Book;
import spring.library.dto.BookDto;
import spring.library.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Long addBook(BookDto bookDto) {
        Book book = bookRepository.save(Book.toBook(bookDto));
        return book.getBookId();
    }

    public Long editBook(Long bookId, BookDto bookDto) {
        Book book = bookRepository.findById(bookId).orElseThrow(); //에러처리하기

        //book.setTitle(bookDto.getTitle()); //하나하나 하는 방법

        Book newBook = bookRepository.save(Book.toBook(bookDto, book.getBookId()));
        return newBook.getBookId();
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookDto::from).toList();
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
