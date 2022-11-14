package net.ict.springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

//    @GetMapping("/hello")   // get 방식으로 들어오는 요청을 매핑한다는 의미
//    public void hello(){
//        log.info("ByeBye...........");
//    }
    // get mapping 하고 나서 servlet-context.xml에 등록해줘야함


    @GetMapping("/ex1")   // get 방식으로 들어오는 요청을 매핑한다는 의미
    public void ex1(String name, int age)
    {
        log.info("ex1...........");
        log.info("name : " + name);
        log.info("age : " + age);
    }


    @GetMapping("/ex2")
    public void ex2(@RequestParam(name ="name", defaultValue = "AAA") String name, @RequestParam(name="age", defaultValue = "20") int age){
                   // 파라미터 값이 넘어오지 않을 때 파라미터의 기본값을 지정해 주는 방식
        log.info("ex2...............");
        log.info("name.. : " + name);
        log.info(("age.. : " + age));
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("ex3.........");
        log.info("dueDate : " + dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("Model info.........");
        model.addAttribute("message", "Hello SpringMVC!!");
    }


    @GetMapping("/ex5")
    public void ex5(TodoDTO todoDTO, Model model){
        log.info("Model TodoDTO info.........");
        log.info(todoDTO);
    }


    @GetMapping("/ex6")
    public String ex6(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("name", "ABC");
        redirectAttributes.addFlashAttribute("result","success");
        // ▼ spring mvc return하는 방법
        return "redirect:/ex7";
    }

    @GetMapping("/ex7")
    public void ex7(){
        // 사용자가 볼 name과 result 값의 페이지가 있어야함
    }


    @GetMapping("/ex8")
    public void ex8(String p1, int p2){
        log.info("p1 ---- " + p1);
        log.info("p2 ---- " + p2);
    }


}
