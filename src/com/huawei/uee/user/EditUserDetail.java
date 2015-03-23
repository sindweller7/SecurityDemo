package com.huawei.uee.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huawei.uee.dbconnect.DAOFactory;

public class EditUserDetail extends HttpServlet
{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String path = "index.jsp" ;
		String username = request.getParameter("username") ;
		int age = Integer.parseInt(request.getParameter("age")) ;
		int money = Integer.parseInt(request.getParameter("money")) ;
		String description = request.getParameter("description") ;
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("detailUser");
		user.setUsername(username);
		user.setAge(age);
		user.setMoney(money);
		user.setDescription(description);
		
		try
		{
			DAOFactory.getUserDAOInstance().updateUser(user);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(user.getAge());
		
		request.getRequestDispatcher(path).forward(request,response) ;
	}

}
