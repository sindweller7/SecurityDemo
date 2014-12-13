package com.huawei.uee.dbconnect ;
public class DAOFactory {
	public static UserDAO getUserDAOInstance() throws Exception{
		return new UserDAOProxy() ;
	}
}