package com.example.shiro;

/**
 * Created by Administrator on 2018/9/7.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
/*
public class ExceptionController {
    @ExceptionHandler(value = UnauthorizedException.class)//处理访问方法时权限不足问题
    public JSONObject defaultErrorHandler(HttpServletRequest req, Exception e)  {
        JSONObject jsonResp = new JSONObject();
        Map<String,Object> map = new HashMap<>();
        map.put("error","403");
        jsonResp.putAll(map);
        return jsonResp;
    }
}*/

@ControllerAdvice
public class ExceptionController implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        // TODO Auto-generated method stub
        System.out.println("==============异常开始=============");
        //如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url
        if(ex instanceof UnauthorizedException){
            ModelAndView mv = new ModelAndView("403");
            return mv;
        }
        ex.printStackTrace();
        System.out.println("==============异常结束=============");
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
        return mv;
    }

}
