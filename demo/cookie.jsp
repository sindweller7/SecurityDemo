<%@ page language="java" import="java.util.*,javax.servlet.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%Cookie cookie1 = new Cookie("name1","manager"); cookie1.setHttpOnly(true); 
  response.addCookie(cookie1);
  Cookie cookie2 = new Cookie("name2","smith"); 
  cookie1.setHttpOnly(false);
  response.addCookie(cookie2);
  %>
  </head>
  
  <body>
  <p>欢迎来到httponly测试页面</p>
  <br/>
  <p>打印cookie信息如下</p>
  <script>
  	document.write(document.cookie);
  </script>
  
  </body>
</html>
