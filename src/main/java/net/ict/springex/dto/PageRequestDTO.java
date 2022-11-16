package net.ict.springex.dto;
/*
    페이지처리 - 현재페이지 번호(page), 한 페이지당 데이터 수(size) 기본적으로 필요
 */

//페이지 처리를 위한 DTO

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    // ▼ lombok에서 page나 size의 기본값 처리할 때 사용
    @Builder.Default // 기본값(고정값이라는 뜻)
    @Min(value = 1)
    @Positive       // 양수 처리만
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    public int getSkip(){
        return (page - 1) * 10;
    }

    private String[] types;   // 필터링할 종류

    private String keyword;   // 검색어 지원

    private boolean finished;  // 완료 여부

    private LocalDate from;

    private LocalDate to;

//    public int getSkip(){return (page-1) * 10;} // 값을 만들어서 리턴

    public boolean checkType(String type){
        if(types ==null || types.length == 0){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }

    public String getLink(){
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);
        if(finished){
            builder.append("&finished=on");
        }
        if(types != null && types.length > 0){
            for(int i = 0; i < types.length; i++){
                builder.append("&types=" + types[i]);
            }
        }
        if (keyword != null) {
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (from != null){
            builder.append("&from=" + from.toString());
        }
        if (to != null){
           builder.append("&to=" + to.toString());
        }

        return builder.toString();

    }


}