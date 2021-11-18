package gdl.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //标记这是一个controller
public class HelloController {

    @GetMapping("/Hello") //html 文件名称
    public String Hello(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);//Model 返回给页面的值, 类似于.net ViewBag
        return "Hello";
    }
}
