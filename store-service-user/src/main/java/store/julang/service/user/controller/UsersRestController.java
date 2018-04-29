package store.julang.service.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import store.julang.entity.message.StandardMessage;
import store.julang.service.user.service.IUserService;

@RestController
@RequestMapping("/users")
public class UsersRestController {
    @Autowired
    @Qualifier("commonUserService")
    public IUserService commonUserService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public StandardMessage signup(String uname, String pwd, String email) throws Exception {
        boolean result = commonUserService.reg(uname, pwd, email);
        return new StandardMessage(StandardMessage.Codes.SUCCESS.ordinal(), result);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public StandardMessage login(String uname, String pwd){
        boolean result = commonUserService.login(uname, pwd);
        return new StandardMessage(StandardMessage.Codes.SUCCESS.ordinal(), result);
    }

}
