package com.huawei.uee.dbconnect ;

import java.util.List;

import com.huawei.uee.user.User;

public class UserDAOProxy implements UserDAO {
	private DatabaseConnection dbc = null ;
	private UserDAO dao = null ;
	public UserDAOProxy() throws Exception 
	{
		this.dbc = new DatabaseConnection() ;
		this.dao = new UserDAOImpl(this.dbc.getConnection()) ;
	}
	
	public boolean isVaildUser(User user) throws Exception
	{
		boolean flag = false ;
		try
		{
			flag = this.dao.isVaildUser(user) ;
		}catch(Exception e)
		{
			throw e ;
		}finally
		{
			this.dbc.close() ;
		}
		return flag ;
	}
	
	
	public  List<User> selectUsersByUsername(String username) throws Exception
	{
		List<User> users = null ;
		try{
			users = this.dao.selectUsersByUsername(username) ;
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return users ;
	}
	
	public void updateUser(User user) throws Exception
	{
		try{
			this.dao.updateUser(user) ;
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
	}
	
	public boolean doCreate(User user) throws Exception{
		boolean flag = false ;
		try{
			if(this.dao.findById(user.getUserId()) == null){
				flag = this.dao.doCreate(user) ;
			}
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return flag ;
	}
	public List<User> findAll(String keyWord) throws Exception{
		List<User> all = null ;
		try{
			all = this.dao.findAll(keyWord) ;
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return all ;
	}
	public User findById(int userno) throws Exception{
		User user = null ;
		try{
			user = this.dao.findById(userno) ;
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return user ;
	}
}