package spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/checkouts")
@RequiredArgsConstructor
@CrossOrigin
public class CheckOutController {

    //대출
    @PostMapping("/{bookId}")
    public ResponseEntity<Void> addCheckOut(@PathVariable Long bookId, @RequestBody Long memberId) {

        return ResponseEntity.ok(null);
    }

    //회원의 대출목록 조회
    @GetMapping("/{memberId}")

    //반납과 대출기록 조회
    @GetMapping("/history/{memberId}")

    //반납
    @PatchMapping("/{checkOutId}/return")

    //반납 기한 연장
    @PatchMapping("/{checkOutId}/renewal")
}
