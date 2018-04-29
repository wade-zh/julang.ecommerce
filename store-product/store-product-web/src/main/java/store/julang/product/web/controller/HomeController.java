package store.julang.product.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /**
     * 商城首页
     * @return
     */
    @GetMapping(value = {"/","/index"})
    public String index(){
        return "home/index";
    }
}
