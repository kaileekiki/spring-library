package spring.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.library.dto.MemberDto;
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;
    private int idNumber;
    private String feature;
    private String email;
    private int phoneNumber;
    private  int borrowedBookNum;

    public static Member toMember(MemberDto memberDto){
        return Member.builder()
                .memberId(memberDto.getMemberId())
                .name(memberDto.getName())
                .idNumber(memberDto.getIdNumber())
                .feature(memberDto.getFeature())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }

    public static Member toMember(MemberDto memberDto, Long memberId){
        return Member.builder()
                .memberId(memberId)
                .name(memberDto.getName())
                .idNumber(memberDto.getIdNumber())
                .feature(memberDto.getFeature())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }

}
