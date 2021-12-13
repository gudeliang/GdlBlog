package gdl.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //标记这是一个controller
public class IndexController {

    @GetMapping("/Index") //html 文件名称
    public String Index() {
        return "Index";
    }

}
