package spring.library.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import spring.library.domain.Member;
import spring.library.dto.MemberDto;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class MemberResponse {

    private Long memberId;
    private String name;
    private int idNumber;
    private String feature;
    private String email;
    private int phoneNumber;

    public static MemberResponse toMemberResponse(MemberDto memberDto){
        return MemberResponse.builder()
                .memberId(memberDto.getMemberId())
                .name(memberDto.getName())
                .idNumber(memberDto.getIdNumber())
                .feature(memberDto.getFeature())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }
}
