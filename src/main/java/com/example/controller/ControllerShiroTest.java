package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/8/31.
 */
@Controller
public class ControllerShiroTest {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String index(Model model, HttpServletResponse response) {
        return "/login.html";
    }
}
