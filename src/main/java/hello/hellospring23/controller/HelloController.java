package hello.hellospring23.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";         // -> \templates에 있는 hello.html로 가서 화면을 실행(랜더링)하라는거임
    }
}