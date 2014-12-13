package com.huawei.uee.transfer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.uee.dbconnect.DAOFactory;
import com.huawei.uee.user.User;

public class TransferAccounts  extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String path = "index.jsp" ;
		String fromUsername = request.getParameter("fromUsername") ;
		String toUsername = request.getParameter("toUsername") ;
		int reduceMoney = Integer.parseInt(request.getParameter("reduceMoney")) ;
		
		User tempUser = new User();
		List<User> users = null;
		//查询转账用户的信息
		tempUser.setUsername(fromUsername);
		try
		{
			users = DAOFactory.getUserDAOInstance().selectUsersByUsername(tempUser.getUsername());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		User fromUser = users.get(0);		
		int fromUserMoney = fromUser.getMoney() - reduceMoney;
		fromUser.setMoney(fromUserMoney);
		
		//查询转账目的用户的信息
		tempUser.setUsername(toUsername);
		try
		{
			users = DAOFactory.getUserDAOInstance().selectUsersByUsername(tempUser.getUsername());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		User toUser = users.get(0);
		int toUserMoney = toUser.getMoney() - reduceMoney;
		toUser.setMoney(toUserMoney);
		
		//更新转账用户账户信息
		try
		{
			DAOFactory.getUserDAOInstance().updateUser(fromUser);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		//更新转账目的用户账户信息
		try
		{
			DAOFactory.getUserDAOInstance().updateUser(toUser);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request,response) ;
	}
}

