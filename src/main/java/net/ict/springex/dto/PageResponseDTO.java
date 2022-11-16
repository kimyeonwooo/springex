package net.ict.springex.dto;

/*
    PageResponseDTO의 기능
     - TodoDTO 목록
     - 전체 데이터의 수
     - 페이지 번호 자리를 위한 데이터(시자페이지 번호, 끝 페이지 번호)
 */

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
            // ▲ 제너릭을 이용한 이유는 다른 종류의 객체를 이용하여 PageResponse를 구성할 수 있도록 하기 위해서
            //   (회원 정보게시판이나 공지사항도 페이징 처리가 필요하므로 공통처리를 위해 제너릭<E>로 처리!)
    private int page;
    private int size;
    private int total;


    //시작페이지 번호
    private int start;

    //끝페이지 번호
    private int end;

    //이전 페이지의 존재 여부
    private boolean prev;
    //다음 페이지의 존재 여부
    private boolean next;

    private List<E> dtoList;

    private String link;

    @Builder(builderMethodName = "withALl")
    private PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;
        // .ceil() 는 올림함수로 소수점이 있을시 무조건 올림처리
        // ex_ total 이 75일때 페이지 갯수는 8
        // 마지막 페이지(end)를 구하는 계산식 end는 현재의 페이지 번호를 기준으로 계산
        this.end = (int)(Math.ceil(this.page/10.0)) * 10;
        // 마지막 페이지를 먼저 계산하는 이유는 시작페이지 게사늘 쉽게 하기 위해
        this.start = this.end-9;

        int last = (int)(Math.ceil((total/(double)size)));
        this.end = end>last ? last : end;

        this.prev = this.start > 1;
        this.next = total > this.end * size;

    }


}
