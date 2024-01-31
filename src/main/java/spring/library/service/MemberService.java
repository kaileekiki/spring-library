package spring.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.domain.Member;
import spring.library.dto.MemberDto;
import spring.library.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long addMember(MemberDto memberDto) {
        Member member = memberRepository.save(Member.toMember(memberDto));
        return member.getMemberId();
    }

    public Long editMember(Long memberId, MemberDto memberDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(); //에러처리하기
        Member newMember = memberRepository.save(member.toMember(memberDto,memberId));
        return newMember.getMemberId();
    }

    public List<MemberDto> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberDto::from).toList();
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

}
