package net.ict.springex.service;

import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.PageResponseDTO;
import net.ict.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

//    List<TodoDTO> getAll(PageRequestDTO pageRequestDTO);
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void delete(TodoDTO todoDTO);

    void update(TodoDTO todoDTo);

    void modify(TodoDTO todoDTO);

}
