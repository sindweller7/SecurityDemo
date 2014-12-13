<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%request.setCharacterEncoding("UTF-8") ;%>
  </head>
  
  <body>
  
  	<form action="UserDetail" method="get">
			<input type="hidden" name="username" value="${param.username}" />
			<input type="hidden" name="opermode" value="view" />
			<input type="submit" value="查看${param.username}的个人信息"/>
	</form>
	
	<form action="UserDetail" method="get">
		<input type="hidden" name="username" value="${param.username}" />
		<input type="hidden" name="opermode" value="edit" />
		<input type="submit" value="编辑${param.username}的个人信息"/>
	</form>
  
  </body>
</html>
