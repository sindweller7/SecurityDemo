package com.huawei.uee.dbconnect ;
import java.util.List;

import com.huawei.uee.user.*;
public interface UserDAO {
	//登陆验证，登陆操作只有两种返回结果
	public boolean isVaildUser(User user) throws Exception ;
	public List<User> selectUsersByUsername(String username) throws Exception;
	public void updateUser(User user) throws Exception;
	
	
	public boolean doCreate(User user) throws Exception ;
	public List<User> findAll(String keyWord) throws Exception ;
	public User findById(int userId) throws Exception ;
}