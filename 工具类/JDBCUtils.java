package cn.itcast.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.tomcat.jni.Thread;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	
	//使用ThreadLocal存取删链接对象
	private static ThreadLocal<Connection> local = new ThreadLocal<>();
	
	
	public static Connection getConnection() throws SQLException{
		return comboPooledDataSource.getConnection();
	}
	
	public static DataSource getDataSource(){
		return comboPooledDataSource;
	}
	//从ThreadLocal获取链接的方法
	public static Connection getCurrentConnection() throws SQLException{
		//先从ThreadLocal获取中
		Connection connection = local.get();
		if(connection != null){
			System.out.println("从local获取数据："+connection);
			return connection;
		}else{
			//如果没有，在从链接池获取，存入ThreadLocal中
			Connection conn = comboPooledDataSource.getConnection();
			System.out.println("从连接池获取数据："+conn);
			local.set(conn);
			return conn;
		}
	}
	//开启事务的方法
	public static void startTransaction() throws SQLException{
		Connection connection = getCurrentConnection();
		System.out.println(connection);
		connection.setAutoCommit(false);
	}
	//提交事务的方法
	public static void commit() throws SQLException{
		Connection connection = getCurrentConnection();
		System.out.println(connection);
		connection.commit();
	}
	
	//回滚事务的方法
	public static void rollback() throws SQLException{
		Connection connection = getCurrentConnection();
		System.out.println(connection);
		connection.rollback();
	}
	
	//释放资源的方法
	public static void close() throws SQLException{
		Connection connection = getCurrentConnection();
		System.out.println(connection);
		local.remove();
		connection.close();
	}
	
}
