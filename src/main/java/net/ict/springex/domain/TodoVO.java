package net.ict.springex.domain;


/* MyBatis와 스프링을 이용한 영속 처리
    1_ VO 선언
    2_ Mapper Interface 만들기
    3_ .xml 개발(씨퀄문)
    4_ 테스트 코드만들기

 */


import lombok.*;

import java.time.LocalDate;


@Getter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
public class TodoVO {

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;



}
