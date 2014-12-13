<%@ page language="java" import="java.util.*,com.huawei.uee.user.User" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <% User user = (User)session.getAttribute("detailUser"); %> 
 <%request.setCharacterEncoding("UTF-8") ;%>
 <%-- user.setUsername("<script>alert(123)</script>");--%>
  </head>
  
  <body>
<br/>
用户<%=user.getUsername()%>的个人信息：
  	<form action="ViewUserDetail" method="get">
		<table border="1">
			<tr>
				<td><p>username</p></td>
				<td><p><%=user.getUsername()%></p></td>
			</tr>
			
			<tr>
				<td><p>age</p></td>
				<td><p><%=user.getAge()%></p></td>
			</tr>
			
			<tr>
				<td><p>money</p></td>
				<td><p><%=user.getMoney()%></p></td>
			</tr>
			
			<tr>
				<td><p>description</p></td>
				<td><p><%=user.getDescription()%></p></td>
			</tr>
		</table>		
	</form>

	<a href="logout.jsp">注销</a>
  </body>
</html>
