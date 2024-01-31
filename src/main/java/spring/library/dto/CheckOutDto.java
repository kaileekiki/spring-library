package spring.library.dto;

import lombok.*;
import spring.library.domain.CheckOut;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckOutDto {

    private Long checkOutId;

    private String title;
    private String author;
    private String checkOutDate;
    private String dueDate;
    private int renewalCount;
    private boolean isReturned;

    public static CheckOutDto from(CheckOut checkOut){
        return CheckOutDto.builder()
                .checkOutId(checkOut.getCheckOutId())
                .title(checkOut.getTitle())
                .author(checkOut.getAuthor())
                .checkOutDate(checkOut.getCheckOutDate())
                .dueDate(checkOut.getDueDate())
                .renewalCount(checkOut.getRenewalCount())
                .isReturned(checkOut.isReturned())
                .build();
    }
}
