package cn.itcast.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *  a). 私有，静态成员变量：ComboPooledDataSource 并创建对象；加载配置文

           件的默认配置。

  b). 公有，静态成员方法：public static DataSource getDataSource()，此方法返

           回C3P0连接池对象；

  c). 公有，静态成员方法：public static Connection getConnection()，此方法返回

           通过C3P0连接池获取的Connection对象；

 * @author Yao Xue
 * @date Aug 19, 2017 8:18:06 PM
 */
public class JDBCUtils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    
    public static DataSource getDataSource() {
        return dataSource;
    }
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return connection;
    }
    
    public static void release(Connection con, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
