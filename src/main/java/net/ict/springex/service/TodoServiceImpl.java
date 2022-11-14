package net.ict.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.dto.domain.TodoVO;
import net.ict.springex.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
// 데이터베이스를 처리하는 TodoMapper 와 DTO 와 VO 변환을 처리하는 ModelMapper 주입

@Service
@Log4j2
@RequiredArgsConstructor
// 생성자 주입방식
//의존성 주입이 필요한 객체의 타입을 finla로 고정하고 생성자 RequiredArgsConstructor를 이용하여 생성자를 생성하는 방식.
public class TodoServiceImpl implements TodoService{
    // todoservice를 구현하는 객체

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
                                //todoDTO에다가 TodoVO를
        log.info(todoVO);
        todoMapper.insert(todoVO);

    }
}
