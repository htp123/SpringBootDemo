package com.example.servlet;

import com.example.bean.User;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2018/8/29.
 */
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*super.doGet(req, resp);*/
        String cityName = req.getParameter("cityName");
        System.out.println("cityName:"+cityName);
        UserServiceImpl userService = new UserServiceImpl();
        List<User> users = userService.getUserList();
        for (User user:users) {
            System.out.println("user:"+user.getUsername());
        }
        PrintWriter pw = resp.getWriter();
        pw.print(users);
    }
}
