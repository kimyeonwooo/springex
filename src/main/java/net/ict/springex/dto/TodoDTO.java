package net.ict.springex.dto;



//객체 자료형은 파라미터로 처리하기 위해서는 객체로 생성되고 setxxx( ) 메소드를 이용해서처리

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long tno;

    @NotEmpty   //빈 문자열 불가
    private String title;

    @Future     //현재보다 미래인 값인지 검증
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer;


}
