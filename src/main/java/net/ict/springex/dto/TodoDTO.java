package net.ict.springex.dto;



//객체 자료형은 파라미터로 처리하기 위해서는 객체로 생성되고 setxxx( ) 메소드를 이용해서처리

import lombok.*;

import java.time.LocalDate;
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;


}
