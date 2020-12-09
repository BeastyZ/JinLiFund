package shopMall.zct.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import shopMall.zct.servlet.sellers.Seller;

/*
 * 服务类
 */
public class MyService {
	
	//建立数据库连接
		public static Connection getDBConnection() {
			
			Connection conn = null;
			
			//注册驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			//准备url、用户名、密码
			String url = "JDBC:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
			String user = "root";
			String password = "123456";
			
			//建立连接
			conn = DriverManager.getConnection(url, user, password);
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
		}
		
		//根据用户名和密码精确查找卖家
		public static Seller findSeller(String username, String password) {
			
			//建立数据库连接
			Connection conn = MyService.getDBConnection();
			
			//QueryRunner DbUtils核心类
			QueryRunner runner = new QueryRunner();
			
			//创建SQL语句
			String sqlStatement = "select * from t_sellers where username=? and password=?";
			
			Seller seller = null;
			
			try {
				//执行SQL语句
				 seller = runner.query(conn, sqlStatement, new BeanHandler<Seller>(Seller.class), username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//释放资源
			DbUtils.closeQuietly(conn);
			
			return seller;
		}
}
