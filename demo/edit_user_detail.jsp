<%@ page language="java" import="java.util.*,com.huawei.uee.user.User" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <%User user = (User)session.getAttribute("detailUser"); %> 
 <%request.setCharacterEncoding("UTF-8") ;%>
 <%-- user.setUsername("<script>alert(123)</script>");--%>
  </head>
  
  <body>
<br/>
<p>用户<%=user.getUsername()%>的个人信息：</p>
  	<form action="EditUserDetail" method="post">
		<table border="1">
			<tr>
				<td><p>username</p></td>
				<td><input type="text" name="username" value="<%=user.getUsername()%>"></input></td>
			</tr>
			
			<tr>
				<td><p>age</p></td>
				<td><input type="text" name="age" value="<%=user.getAge()%>"></input></td>
			</tr>
			
			<tr>
				<td><p>money</p></td>
				<td><input type="text" name="money" value="<%=user.getMoney()%>"></input></td>
			</tr>
			
			<tr>
				<td><p>description</p></td>
				<td><input type="text" name="description" value="<%=user.getDescription()%>"></input></td>
			</tr>
		</table>
		<p><input type="submit" value="提交"/></p>
	</form>
	<p>转账：</p>
	<form action="TransferAccounts" method="get">
	
	<input type="hidden" name="fromUsername" value="<%=user.getUsername()%>"></input>
	用户名：<input type="text" name="toUsername" value=""></input>
	转账金额：<input type="text" name="reduceMoney" value=""></input>
	<input type="submit" value="转账"></input>
	
	</form>
	<br/>
	<a href="logout.jsp">注销</a>
  
  </body>
</html>
