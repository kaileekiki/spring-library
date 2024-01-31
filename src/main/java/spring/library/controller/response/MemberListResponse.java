package spring.library.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.dto.MemberDto;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class MemberListResponse{
    private List<MemberDto> members;
    public MemberListResponse(List<MemberDto> memberDtos) {

        this.members = memberDtos;
        memberDtos.stream().map(MemberResponse::toMemberResponse).toList();
    }
}
