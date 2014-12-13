package com.huawei.uee.dbconnect ;

import java.util.List;

import com.huawei.uee.user.User;

public class TestDAOInsert{
	public static void main(String args[]) throws Exception{
		User user = new User();
		user.setUsername("manager");
		List<User> users = 	DAOFactory.getUserDAOInstance().selectUsersByUsername(user.getUsername());
		user = users.get(0);
		System.out.println(user.getAge());
	}
}