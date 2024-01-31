package spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.form.MemberForm;
import spring.library.controller.response.MemberListResponse;
import spring.library.dto.MemberDto;
import spring.library.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {

    private final MemberService memberService;

    //추가
    @PostMapping
    public ResponseEntity<Void> addMember(@RequestBody MemberForm form) {
        Long memberId = memberService.addMember(MemberDto.from(form));
        return ResponseEntity.ok(null);
    }

    //수정
    @PutMapping("/{memberId}")
    public ResponseEntity<Void> editMember(@PathVariable Long memberId, @RequestBody MemberForm form){
        Long newMemberId = memberService.editMember(memberId, MemberDto.from(form));
        return ResponseEntity.ok(null);
    }

    //보기
    @GetMapping
    public ResponseEntity<MemberListResponse> getAllMember(){
        List<MemberDto> memberDtos = memberService.getAllMembers();
        MemberListResponse response = new MemberListResponse(memberDtos);
        return ResponseEntity.ok(response);
    }

    //삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.ok(null);
    }

}
