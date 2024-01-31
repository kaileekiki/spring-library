package spring.library.controller.form;
// 회원이 회원등록
//관리자가 회원 등록
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberForm {

    private String name;
    private int idNumber;
    private String feature;
    private String email;
    private int phoneNumber;

}
