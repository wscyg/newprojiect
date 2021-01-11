package com.ws.admin.controller;


import com.ws.admin.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {


    /*
    来登录页*/

    @GetMapping(value={"/","/login"})
    public String Loginpage(){
         return "login";
    }

    //处理登录请求
    @PostMapping("/login")
    public String Main(User user, HttpSession session, Model model){
        if(StringUtils.isEmpty(user.getUsername())&&StringUtils.isEmpty(user.getPassword())){
            session.setAttribute("loginuser",user);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
        //转发return "main";
        //重定向防止表单重复提交


    }
    @GetMapping("/main.html")
    public String reMain(){
        return "main";
    }

    @GetMapping("/main.html")
    public String rMain(){
        return "main";
    }
}
