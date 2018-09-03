package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/30.
 */
@Controller
public class UserControllerTest {
    @Autowired
    UserService userService;

    @RequestMapping(value = "getUserList" ,method = RequestMethod.POST)
    public @ResponseBody  JSONObject getUserListFunc(@RequestBody String request){
        JSONObject json = JSONObject.fromObject(request);
        Iterator<String> iterator = json.keys();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key + ":" + json.get(key));
        }

        JSONObject jsonResp = new JSONObject();
        List<User> user  = userService.getUserList();
        Map<String,Object>  map= new HashMap<String,Object>();
        map.put("userList",user);

        if(!user.isEmpty()){
            jsonResp.putAll(map);
            jsonResp.put("number",user.size());
        }else{
            jsonResp.put("number","0");
        }

        return jsonResp;
    }

}
