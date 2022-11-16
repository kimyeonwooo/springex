package net.ict.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.PageResponseDTO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.domain.TodoVO;
import net.ict.springex.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
// 데이터베이스를 처리하는 TodoMapper 와 DTO 와 VO 변환을 처리하는 ModelMapper 주입

@Service
@Log4j2
@RequiredArgsConstructor
// 생성자 주입방식
//의존성 주입이 필요한 객체의 타입을 finla로 고정하고 생성자 RequiredArgsConstructor를 이용하여 생성자를 생성하는 방식.
public class TodoServiceImpl implements TodoService {
    // todoservice를 구현하는 객체

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        //todoDTO을 TodoVO 타입으로 변환
        log.info(todoVO);
        todoMapper.insert(todoVO);

    }

//    @Override
//    public List<TodoDTO> getAll(PageRequestDTO pageRequestDTO) {
//        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//                                        // stream() : builder와 비슷
//                                .map(vo->modelMapper.map(vo, TodoDTO.class))
//                                .collect(Collectors.toList());
//        return dtoList;
//        }
        /*
            List<TodoVo>를 List<TodoDTO>로 변환하는 작업을 stream을 이용하여
            각 TodoVO는 map()을 통해서 TodoDTO로 바꾸고 collect()을 이용하여 List<TodoDTO>로 묶어준다.
         */


    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        int total = todoMapper.getCount(pageRequestDTO);
        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withALl()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }

    @Override
    public TodoDTO getOne(Long tno) {

        TodoVO todoVO = todoMapper.selectOne(tno);

        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        // ▲ modelMapper을 통해서 가져온 todoVO 타입을 TodoDTO 클래스 타입으로 바꾸는 과정
        return todoDTO;
    }

    @Override
    public void delete(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
//        log.info("여기값은????");
        log.info(todoVO);
//        log.info("todoVO.getTno 값을 뽑아야대");
        todoMapper.delete(todoVO);
    }

    @Override
    public void update(TodoDTO todoDTo) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTo, TodoVO.class);
        log.info(todoVO);
        todoMapper.update(todoVO);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.update(todoVO);
    }
}
