package com.huawei.uee.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huawei.uee.dbconnect.DAOFactory;

public class UserDetail extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String viewPath = "view_user_detail.jsp" ;
		String editPath = "edit_user_detail.jsp";
		String username = request.getParameter("username") ;
		String opermode = request.getParameter("opermode") ;
		User detailUser = new User();
		detailUser.setUsername(username);
		List<User> users = null;
		try
		{
			users = DAOFactory.getUserDAOInstance().selectUsersByUsername(detailUser.getUsername());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		detailUser = users.get(0);
		System.out.println(detailUser.getAge());
		
		//将用户信息存入session
		HttpSession session = request.getSession();
		session.setAttribute("detailUser",detailUser) ;
		
		if(opermode.equals("view"))
		{
			request.getRequestDispatcher(viewPath).forward(request,response) ;
		}else if(opermode.equals("edit"))
		{
			request.getRequestDispatcher(editPath).forward(request,response) ;
		}else
		{
			System.out.println("error");
		}
		
	}

}
