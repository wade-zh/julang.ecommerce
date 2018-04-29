package store.julang.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntranceController {

    @RequestMapping("/")
    public String index() {
        return "login/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login/index";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup/index";
    }
}
