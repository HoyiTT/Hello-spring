package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    ///hello로 접속시 진행됨
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
        //viewname : hello
    }

    //MVC와 템플릿엔진(GET 방식 사용)
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody //API로 사용할 경우 추가
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //API
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    //리턴 값이 텍스트가 아니라 객체가 오면 JSON 방식으로 출력함(기본 정책)

    //Getter Setter
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}

