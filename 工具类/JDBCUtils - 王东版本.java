package cn.itcast.day37anli.utils;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	// 默认配置
	private static ComboPooledDataSource dataSource01 = new ComboPooledDataSource();

	// 代表线程局部变量,通过这个局部变量可以为当前的线程绑定连接
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	// 命名配置
	//private static ComboPooledDataSource dataSource02 = new ComboPooledDataSource("itcast");

	// 返回数据源(连接池)
	public static DataSource getDataSource() {
		return dataSource01;
	}

	// 返回连接
	public static Connection getConnection() {
		// 从当前线程获取连接
		Connection conn = tl.get();
		try {
			if (null == conn) {
				// 从数据源中获取连接
				conn = dataSource01.getConnection();
				tl.set(conn);
			}
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 开启事务
	public static void startTransaction() {
		// 从当前线程获取连接
		Connection conn = tl.get();
		try {
			if (null == conn) {
				// 从数据源中获取连接
				conn = dataSource01.getConnection();
				tl.set(conn);
			}
			// 开启事务
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 提交事务
	public static void commitTransaction() {
		// 从当前线程获取连接
		Connection conn = tl.get();
		try {
			if (null == conn) {
				// 从数据源中获取连接
				conn = dataSource01.getConnection();
				tl.set(conn);
			}
			// 开启事务
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 回滚事务
	public static void rollBack() {
		// 从当前线程获取连接
		Connection conn = tl.get();
		try {
			if (null == conn) {
				// 从数据源中获取连接
				conn = dataSource01.getConnection();
				tl.set(conn);
			}
			// 开启事务
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void closeResource (ResultSet rs,Statement stmt,Connection conn) {
		if(null!=rs){
			try {
				rs.close();
				rs = null;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		if(null!=stmt){
			try {
				stmt.close();
				stmt = null;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		if(null!=conn){
			try {
				conn.close();
				conn = null;
			} catch (Exception e) {
			}
		}
	} 

	
	
	public static void closeResource () {
		// 从当前线程获取连接
		Connection conn = tl.get();
		if(null!=conn){
			try {
				conn.close();
				conn = null;
			} catch (Exception e) {
			}
		}
	} 

	public static void main(String[] args) {
		System.out.println(getConnection());
		
	}
	
	
}
