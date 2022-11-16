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


}
