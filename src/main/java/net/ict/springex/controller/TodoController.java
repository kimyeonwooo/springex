package net.ict.springex.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")        //requestMapping 의 value 값은 todo
@Log4j2
@RequiredArgsConstructor
public class TodoController {

        private final TodoService todoService;



        @RequestMapping("/list")        // 최종 경로 : /todo/list
        public void list(@Valid PageRequestDTO pageRequestDTO,BindingResult bindingResult, Model model){
            log.info("todo list........");

            if(bindingResult.hasErrors()){
                pageRequestDTO = PageRequestDTO.builder().build();
            }

            model.addAttribute("responseDTO",todoService.getList(pageRequestDTO));
                     // model에는 'dtoList'라는 이름으로 목록 데이터가 담겨있음

        }


        // get방식
        @RequestMapping(value = "/register", method = RequestMethod.GET)   // 최종 경로 : /todo/register
        public void register(){
            log.info("todo request......");
        }


        // post방식
        // ' /todo/register '를 POST방식으로 처리하는 메소드 TodoDTO를 파라미터로 적용
       @PostMapping("/register")
        public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
                                     //  ▲ TodoDTO는 검증 대상이라는 것을 의미
            log.info("POST todo register...............");
            
            // 검증에 대한 메소드
            if(bindingResult.hasErrors()){
                log.error("has errors,,,,,,,");                
                redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
                                       // ▲ 한 번 사용하고 없어지는 거
                return "redirect:/todo/register";
            }
            
            log.info(todoDTO);
            // post방식으로 받으려는 객체는 DTO 형식으로 먼저 만들어두고 그 뒤에 받으면 됨
            todoService.register(todoDTO);
            return "redirect:/todo/list";
        }

        @GetMapping({"/read", "/modify"})
        public void read(Long tno, Model model){

            TodoDTO todoDTO = todoService.getOne(tno);

            log.info(todoDTO);
            model.addAttribute("dto", todoDTO);
            // model(request)에 담는 것
        }


//        @PostMapping("/remove")
//        public String remove(Long tno, RedirectAttributes redirectAttributes){
//            log.info("tno", tno);
//            todoService.delete(TodoDTO todoDTO);
//            return "redirect:/todo/list";
//        }



        @PostMapping("/delete")
        public String deletePost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
            //  ▲ TodoDTO는 검증 대상이라는 것을 의미
            log.info("POST todo delete...............");

            // 검증에 대한 메소드
            if(bindingResult.hasErrors()){
                log.error("has errors,,,,,,,");
                redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
                // ▲ 한 번 사용하고 없어지는 거
                return "redirect:/todo/read";
            }

            log.info(todoDTO);
            // post방식으로 받으려는 객체는 DTO 형식으로 먼저 만들어두고 그 뒤에 받으면 됨
            todoService.delete(todoDTO);
            return "redirect:/todo/list";
        }

        @PostMapping("/modify")
        public String modify(@Valid TodoDTO todoDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
            if(bindingResult.hasErrors()) {
                log.info("has errors.......");
                redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
                redirectAttributes.addAttribute("tno", todoDTO.getTno() );
                return "redirect:/todo/modify";
            }
            log.info(todoDTO);
            todoService.modify(todoDTO);
            return "redirect:/todo/list";
        }

}
