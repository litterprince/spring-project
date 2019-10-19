package com.spring.simple.action;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.simple.service.UserService;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/index")
    public String index(HttpServletRequest request){
        /*UserBean param = new UserBean();
        param.setUserName("123");
        List<UserBean> userList = userService.findByParam(param);*/
        log.error("error");
        return "index";
    }
}
