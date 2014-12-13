<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<html>
<head>
<title>用户登录</title>
<style type="text/css">
form {
  font-size: 1.4em;
	width: 40em;
 position:relative;
	 top:50px;
	 left:50%;
	 margin:0 0 0 -20em;
}
</style>

</head>
<body>
<%request.setCharacterEncoding("UTF-8") ;%>
<%
	List<String> info = (List<String>) request.getAttribute("info") ;
	
	// 有信息返回
	if(info != null){	
		Iterator<String> iter = info.iterator() ;
		while(iter.hasNext()){
%>
			<h4><%=iter.next()%></h4>
<%
		}
	}
%>
<form action="Login" method="get">
	用户ID：<input type="text" name="username"></input><br>
	密&nbsp;&nbsp;码：<input type="password" name="password"></input><br/>
	<input type="submit" value="登陆">
	<input type="reset" value="重置">
</form>
</body>
</html>