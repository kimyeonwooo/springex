package net.ict.springex.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    @Select("select now()")     // mapper interface : 세미콜론(;) 없음
                                // root-context.xml에 설정해줘야함
    String getTime();


}
