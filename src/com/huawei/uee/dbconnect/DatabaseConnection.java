package com.huawei.uee.dbconnect ;
import java.sql.Connection ;
import java.sql.DriverManager ;
public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.OracleDriver" ; 
	private static final String DBURL = "jdbc:oracle:thin:@192.168.0.9:1521:orcl" ;
	private static final String DBUSER = "scott" ;
	private static final String DBPASSWORD = "tiger" ;
	private Connection conn ;
	public DatabaseConnection() throws Exception {
		Class.forName(DBDRIVER) ;
		this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
	}
	public Connection getConnection(){
		return this.conn ;
	}
	public void close() throws Exception {
		if(this.conn != null){
			try{
				this.conn.close() ;
			}catch(Exception e){
				throw e ;
			}
		}
	}
}