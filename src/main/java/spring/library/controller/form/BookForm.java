package spring.library.controller.form;
//관리자가 책 추가할때 쓰는 폼
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookForm {

    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String classification;

}
