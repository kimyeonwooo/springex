package net.ict.springex.controller;


import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo")        //requestMapping 의 value 값은 todo
@Log4j2
public class TodoController {

        @RequestMapping("/list")        // 최종 경로 : /todo/list
        public void list(Model model){
            log.info("todo list........");
        }


        // get방식
        @RequestMapping(value = "/register", method = RequestMethod.GET)   // 최종 경로 : /todo/register
        public void register(){
            log.info("todo request......");
        }


        // post방식
        // ' /todo/register '를 POST방식으로 처리하는 메소드 TodoDTO를 파라미터로 적용
       @PostMapping("/register")
        public String registerPost(TodoDTO todoDTO, RedirectAttributes redirectAttributes){
            log.info("POST todo register...............");
            log.info(todoDTO);
            // post방식으로 받으려는 객체는 DTO 형식으로 먼저 만들어두고 그 뒤에 받으면 됨

            return "redirect:/todo/list";
        }




}
