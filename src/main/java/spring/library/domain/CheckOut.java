package spring.library.domain;

import jakarta.persistence.*;
import lombok.*;
import spring.library.dto.BookDto;
import spring.library.dto.CheckOutDto;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckOut extends Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkOutId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    private LocalDate checkOutDate;
    private LocalDate dueDate;
    private int renewalCount;
    private boolean isReturned;


    /*
    public static CheckOut toCheckOut(CheckOutDto checkOutDto) {
        return CheckOut.builder()
                .checkOutId(checkOutDto.getCheckOutId())
                .checkOutDate(checkOutDto.getCheckOutDate())
                .dueDate(checkOutDto.getDueDate())
                .renewalCount(checkOutDto.getRenewalCount())
                .isReturned(checkOutDto.isReturned())
                .build();
    }
    */


    //첵아웃 만들기
    public static CheckOut from(Book book, Member member) {
        return CheckOut.builder()
                .member(member)
                .book(book)
                .checkOutDate(LocalDate.now())
                .dueDate(LocalDate.now())
                .renewalCount(0)
                .isReturned(false)
                .build();
    }

    //멤버에서 빌린 책 추가
}