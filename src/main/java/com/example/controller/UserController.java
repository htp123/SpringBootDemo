package com.example.controller;

/**
 * Created by Administrator on 2018/8/27.
 */
import com.example.bean.User;
import com.example.util.JsonResult;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*@RestController*/
//@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
    String index(){
        return "Hello Spring Boot!";
    }

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    /*@RequestMapping(value = "user/tt", method = RequestMethod.GET)*/
    /*public @ResponseBody  User getUserById(@PathParam(value = "id")String id)*/
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
/*    public @ResponseBody  User getUserById(@PathVariable(value = "id") String id)
    {
        System.out.println("test...");
        User user = userService.getUserById(Integer.parseInt(id));
        return user;
    }*/
    public  @ResponseBody  ResponseEntity<JsonResult> getUserById (@PathVariable(value = "id") Integer id){
        System.out.println("id["+id+"]");
        JsonResult r = new JsonResult();
        try {
            User user = userService.getUserById(id);
            r.setResult(user);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
//    public @ResponseBody ResponseEntity<JsonResult> getUserList (@RequestParam Map<String,Object> request)
    public @ResponseBody List<User> getUserList (@RequestParam Map<String,Object> request)
    {
        String cityName =(String)request.get("cityName");
        System.out.println("cityName:"+cityName);
        /*JsonResult r = new JsonResult();*/
        try {
            List<User> users = userService.getUserList();
            for (User user:users) {
                System.out.println("user:"+user.getUsername());
            }
            return users;
          /*  r.setResult(users);
            r.setStatus("ok...");*/
        } catch (Exception e) {
            /*r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");*/
            e.printStackTrace();
        }
       return null;
//        return ResponseEntity.ok(r);
    }


/*  public ResponseEntity<JsonResult> users(HttpServletRequest request){
      String cityName = (String)request.getParameter("cityName");
      System.out.println("cityName:"+cityName);
      return null;
  }*/

   /* public String getData(HttpServlettRequest request){
        String ss= request.getParameter(“xxx”); //ss=>xx
}

    public String getData(){
        HttpServletRequest request=  ServletActionContext.getRequest();
        String ss =  request.getParameter("xxx");  //ss=>xx
    }*/

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            int orderId = userService.add(user);
            if (orderId < 0) {
                r.setResult(orderId);
                r.setStatus("fail");
            } else {
                r.setResult(orderId);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "id") Integer id){
        JsonResult r = new JsonResult();
        try {
            int ret = userService.delete(id);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("id") Integer id, @RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            int ret = userService.update(id, user);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

}
