<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>
    function sendAjax()
    {
        var cityname = $("#cityName").val();
        $.ajax(
            {
                url:"http://localhost:8088/users",
                data:{"cityName":cityname},
                type:"get",
                dataType:"json",
                success:function(data)
                {
                    /*alert(data.name);*/
                    alert(data.size)
                },
                error: function() {
                    alert("error");
                }
            });
    }
</script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Springboot + Jsp</title>
</head>
<body>
${hello}
<p>启动方式</p>

<ol>
    <li>spring-boot:run</li>
    <li>打包成war，通过 java -jar demo-0.0.1-SNAPSHOT.war启动</li>
</ol>
<p>jar包运行的时候会404错误，因为默认jsp不会被拷贝到程序包中，而war包里面有包含了jsp，所以没问题。</p>
<p>另外springboot官方并不推荐使用jsp</p>
<input name="cityName" id="cityName"type=text/>
<button onclick="sendAjax()">提交</button>
</body>
</html>


<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<script>
    function sendAjax()
    {
        var cityname = $("#cityName").val();
        $.ajax(
            {
                url:"http://localhost:8088/users",
                data:{"cityName":cityname},
                type:"get",
                dataType:"json",
                success:function(data)
                {
                    /*alert(data.name);*/
                    alert(data.size)
                },
                error: function() {
                    alert("error");
                }
            });
    }
</script>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Springboot + Jsp</title>
    <script type="text/javascript" src="static/jquery-3.3.1.js></script>
</head>

<body>
${hello}
<p>启动方式</p>

<ol>
    <li>spring-boot:run</li>
    <li>打包成war，通过 java -jar demo-0.0.1-SNAPSHOT.war启动</li>
</ol>

<p>jar包运行的时候会404错误，因为默认jsp不会被拷贝到程序包中，而war包里面有包含了jsp，所以没问题。</p>
<p>另外springboot官方并不推荐使用jsp</p>

<input name="cityName" id="cityName" type=text>
    <button onclick="sendAjax()">提交</button>
    </body>
</html>

--%>
