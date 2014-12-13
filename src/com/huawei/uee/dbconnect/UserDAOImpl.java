package com.huawei.uee.dbconnect ;
import java.util.* ;
import java.sql.* ;

import com.huawei.uee.user.User;

public class UserDAOImpl implements UserDAO {
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	private Statement stmt = null ;
	
	public UserDAOImpl(Connection conn){
		this.conn = conn ;
	}
	
	/*
	 * 判断用户输入的用户名和密码是否合法
	 */
	public boolean isVaildUser(User user) throws Exception
	{
		boolean flag = false ;
		String sql = "SELECT username FROM T_UEE_USER WHERE username = '" + user.getUsername() +"' AND password = '" + user.getPassword() +"'" ;
		this.stmt = conn.createStatement();
		ResultSet rs = this.stmt.executeQuery(sql);
		if(rs.next()){
			flag = true ;
		}
		this.stmt.close() ;
		return flag ;
	}
	

	/*
	 * 根据username查询用户详细信息
	 */
	public List<User> selectUsersByUsername(String username) throws SQLException
	{
		List<User> users = new ArrayList<User>() ;
//		String sql = "SELECT userId,authId,username,password，age,money,description FROM T_UEE_USER WHERE username = '" +username +"'" ;
//		this.stmt = conn.createStatement();
		
		String sql = "SELECT userId,authId,username,password，age,money,description FROM T_UEE_USER WHERE username LIKE ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1,"%"+username+"%");
		ResultSet rs = this.pstmt.executeQuery() ;
		
		User user = null;
		while(rs.next())
		{
			user = new User() ;
			user.setUserId(rs.getInt(1));
			user.setAuthId(rs.getInt(2));
			user.setUsername(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setAge(rs.getInt(5));
			user.setMoney(rs.getInt(6));
			user.setDescription(rs.getString(7));
			users.add(user) ;
		}
		this.pstmt.close() ;
		return users;
	}
	
	public void updateUser(User user) throws Exception
	{
		String sql = "UPDATE T_UEE_USER SET age=?,money=?,description=? WHERE username=?";
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, user.getAge());
		this.pstmt.setInt(2, user.getMoney());
		this.pstmt.setString(3, user.getDescription());
		this.pstmt.setString(4,user.getUsername());
		this.pstmt.executeQuery() ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean doCreate(User user) throws Exception{
		boolean flag = false ;
		String sql = "INSERT INTO user(userno,ename,job,hiredate,sal) VALUES (?,?,?,?,?)" ;
//		this.pstmt = this.conn.prepareStatement(sql) ;
//		this.pstmt.setInt(1,user.getUserno()) ;
//		this.pstmt.setString(2,user.getEname()) ;
//		this.pstmt.setString(3,user.getJob()) ;
//		this.pstmt.setDate(4,new java.sql.Date(user.getHiredate().getTime())) ;
//		this.pstmt.setFloat(5,user.getSal()) ;
		if(this.pstmt.executeUpdate() > 0){
			flag = true ;
		}
		this.pstmt.close() ;
		return flag ;
	}
	
	
	public List<User> findAll(String keyWord) throws Exception{
		List<User> all = new ArrayList<User>() ;
		String sql = "SELECT userno,ename,job,hiredate,sal FROM user WHERE ename LIKE ? OR job LIKE ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1,"%"+keyWord+"%") ;
		this.pstmt.setString(2,"%"+keyWord+"%") ;
		ResultSet rs = this.pstmt.executeQuery() ;
		User user = null ;
		while(rs.next()){
			user = new User() ;
//			user.setUserno(rs.getInt(1)) ;
//			user.setEname(rs.getString(2)) ;
//			user.setJob(rs.getString(3)) ;
//			user.setHiredate(rs.getDate(4)) ;
//			user.setSal(rs.getFloat(5)) ;
			all.add(user) ;
		}
		this.pstmt.close() ;
		return all ;
	}
	public User findById(int userno) throws Exception{
		User user = null ;
		String sql = "SELECT userno,ename,job,hiredate,sal FROM user WHERE userno=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1,userno) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			user = new User() ;
//			user.setUserno(rs.getInt(1)) ;
//			user.setEname(rs.getString(2)) ;
//			user.setJob(rs.getString(3)) ;
//			user.setHiredate(rs.getDate(4)) ;
//			user.setSal(rs.getFloat(5)) ;
		}
		this.pstmt.close() ;
		return user ;
	}
}