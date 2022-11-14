package net.ict.springex.mapper;

import net.ict.springex.dto.domain.TodoVO;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);


}
