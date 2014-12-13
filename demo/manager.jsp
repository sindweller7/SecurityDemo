<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%request.setCharacterEncoding("UTF-8") ;%>
  </head>
  
  <body>

  	<form action="UserDetail" method="get">
		<table border="0">
			<tr>
				<td><p>manager的个人信息</p></td>
				<td><input type="hidden" name="username" value="manager" /></td>
				<td><input type="hidden" name="opermode" value="view" /></td>
				<td><input type="submit" value="查看"/></td>
			</tr>
		</table>
	</form>
	<br/>
	<br/>
	
  	<form action="UserDetail" method="get">
		<table border="0">
			<tr>
				<td><p>john的个人信息</p></td>
				<td><input type="hidden" name="username" value="john" /></td>
				<td><input type="hidden" name="opermode" value="view" /></td>
				<td><input type="submit" value="查看"/></td>
			</tr>
		</table>
	</form>
	<br/>
	<br/>
	
	<form action="UserDetail" method="get">
		<table border="0">
			<tr>
				<td><p>smith的个人信息</p></td>
				<td><input type="hidden" name="username" value="smith" /></td>
				<td><input type="hidden" name="opermode" value="view" /></td>
				<td><input type="submit" value="查看"/></td>
			</tr>
		</table>
	</form>
	<br/>
	<br/>
	
	<form action="UserDetail" method="get">
		<input type="hidden" name="username" value="manager" />
		<td><input type="hidden" name="opermode" value="edit" /></td>
		<input type="submit" value="编辑个人信息"/>
	</form>
  
  </body>
</html>
