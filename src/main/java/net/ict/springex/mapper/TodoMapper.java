package net.ict.springex.mapper;

import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();   // 작성 후 mapper.xml로!

    TodoVO selectOne(Long tno);

    void delete(TodoVO todoVO);

    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
    // 여기에 매핑되는 메소드가 있어야함(TodoMapper.xml에)

    int getCount(PageRequestDTO pageRequestDTO);
}
