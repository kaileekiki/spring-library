package spring.library.service;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.domain.Book;
import spring.library.domain.CheckOut;
import spring.library.domain.Member;
import spring.library.dto.BookDto;
import spring.library.dto.CheckOutDto;
import spring.library.dto.MemberDto;
import spring.library.repository.BookRepository;
import spring.library.repository.CheckOutRepository;
import spring.library.repository.MemberRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CheckOutService {
    private final CheckOutRepository checkOutRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public void addCheckOut (Long bookId, Long memberId) {
        //멤버 아이디와 북 아이디가 포함된
        // 거 불러오기
        // 새로운 체크아웃을 만들어서 저장
        //멤버 아이디의 멤버에서 빌린 책 수 1 증가
        //북 아이디의 상태를 대출중으로 바꿈
        //멤버가 빌린 책을 조회할 때 멤버 아이디로 checkout을 조회 가능하게
        Book book = bookRepository.findById(bookId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();
        checkOutRepository.save(CheckOut.from(book,member));
    }

}
