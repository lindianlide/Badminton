package com.badminton.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class BaseDaoUtils {
	private static Connection conn=null;
	private static PreparedStatement pstm=null;
	//private final static String URL="jdbc:sqlserver://localhost:13964;DatabaseName=badminton";
	private final static String URL="jdbc:sqlserver://localhost:1433;DatabaseName=badminton";
	private final static String USER="lindianli";
	private final static String PWD="ldl123789";
	private static ResultSet rs=null;
	DataSource ds=null;
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 得到连接
	 * @return
	 */
	public Connection getConnection(){
		
		try {
			conn=DriverManager.getConnection(URL,USER,PWD);
			//InitialContext ctx= new InitialContext();
			//ds=(DataSource)ctx.lookup("java:comp/env/oraclepool");
			//conn=ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 带占位符的增删改
	 * @param sql
	 * @param paramValues
	 * @return
	 */
	public int executeUpdate(String sql,Object[] paramValues){
		conn=this.getConnection();
		int ret=0;
		try {
			
			pstm=conn.prepareStatement(sql);
			if(paramValues!=null){
			for(int i=0;i<paramValues.length;i++){
			pstm.setObject(i+1, paramValues[i]);
			}
			}
			ret=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret=-1;
		}
		finally{
			closeStatement();
		}
		return ret;
	}

	/**
	 * 不带占位符的增删改
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql){
		return this.executeUpdate(sql, null);
	}
	public void closeAll(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstm!=null){
				pstm.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public void closeStatement(){
		try {
			
			if(pstm!=null){
				pstm.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 不带占位符的查询功能
	 * @param sql
	 * @return
	 */
	public ResultSet executeQuery(String sql){
		
		return this.executeQuery(sql, null);
	}
	/**
	 * 带占位符的查询功能
	 * @param sql
	 * @param paramValues
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object[] paramValues){
		conn=this.getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			if(paramValues!=null){
				for(int i=0;i<paramValues.length;i++){
					pstm.setObject(i+1, paramValues[i]);
				}
			}
			rs=pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
}
