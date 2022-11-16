package net.ict.springex.mapper;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.PageResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sun.jvm.hotspot.debugger.Page;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testgetTime(){
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder()
                .title("spring Test")
                .dueDate(LocalDate.of(2022,11,14))
                .writer("ict05")
                .build();
        todoMapper.insert(todoVO);
    }


    @Test
    public void testSelectAll(){
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo));
    }




    @Test
    public void testSelectOne(){
        long tno = 2;
        todoMapper.selectOne(tno);
        log.info(todoMapper.selectOne(2L));
    }

    @Test
    public void testDelete() {
        TodoVO todoVO = TodoVO.builder()
                .tno(2L)
                .build();
        todoMapper.delete(todoVO);
    }


    @Test
    public void testUpdate(){
        TodoVO todoVO = TodoVO.builder()
                .title("반갑습니다요~")
                .dueDate(LocalDate.of(2022,12,12))
                .finished(false)
                .tno(4L)
                .build();
        todoMapper.update(todoVO);
    }


    @Test
    public void testSelectList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectSearch(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t","w"})  // t = title, w = write
                .keyword("졸려")
                .finished(false)
                .from(LocalDate.of(2022,11,14))
                .to(LocalDate.of(2022,11,16))
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
    }
}
