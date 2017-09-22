package me.xueyao.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
* DBUtils工具类，提供数据库连接池对象和数据库连接对象
*/
public class DBUtils {
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();

	//使用ThreadLocal保存链接对象
	//可以保存当前线程变量的一个容器
	/**
	 * 在ThreaLocal中，有三个方法，这三个方法都在操作当前线程（Thread t = Thread.currentThread();）
	 * 获取线程中的变量（ThreadLocalMap threadLocals），在这个变量中存取删数据
	 * 
	 * ThreaLocal不是一个容器，操作容器（ThreadLocalMap threadLocals）的工具
	 * */
	private static ThreadLocal<Connection> local = new ThreadLocal<>();
	
	// 获取数据源
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}

	// 获取连接
	public static Connection getConnection() throws SQLException {
		return DATA_SOURCE.getConnection();
	}
	
	// 通过ThreadLocal获取连接
	public static Connection getCurrentConnection() throws SQLException {
		Connection conn = local.get();
		if(conn != null){
			System.out.println("从local获取数据："+conn);
			return conn;
		}else{
			Connection connection = DATA_SOURCE.getConnection();
			System.out.println("从DATA_SOURCE获取数据："+connection);
			local.set(connection);
			return connection;
		}
	}

	public static void startTransaction() throws SQLException {
		
		Connection conn = getCurrentConnection();
		System.out.println(conn);
		conn.setAutoCommit(false);
	}

	public static void commit() throws SQLException {
		Connection conn = getCurrentConnection();
		System.out.println(conn);
		conn.commit();
	}

	public static void rollBack() throws SQLException {
		Connection conn = getCurrentConnection();
		System.out.println(conn);
		conn.rollback();
	}

	public static void close() throws SQLException {
		Connection conn = getCurrentConnection();
		System.out.println(conn);
		local.remove();
		conn.close();
	}
}
