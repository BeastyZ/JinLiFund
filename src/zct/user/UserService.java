package zct.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * 用户服务类，所有业务逻辑
 */

public class UserService {
	
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
	
	// 用户登录
	public static boolean login(String username, String password) {
		
		boolean result = false;
		Connection conn = null;
		List<User> users;
		
		try {
			conn = UserService.getDBConnection();//建立数据库连接
			QueryRunner runner = new QueryRunner();//QueryRunner DbUtils核心类，JavaBean
			
			String sql = "select * from t_user where username=? and password=?";
			
			users = runner.query(conn, sql, new BeanListHandler<User>(User.class));
			
			if(users.size() > 0) {
				result = true;
			}
			else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	
	//添加用户
	public static void addUser(String usernameReg, String passwordReg, String major, String gender, String fileName, String userHobbies, String regDate, String ipAddr) {
		
		//与数据库建立连接
		Connection conn = UserService.getDBConnection();
		
		//获取用于向数据库发送SQL语句的statement
		PreparedStatement ps = null;
		try {
			//编写SQL语句
			String sqlStatement = "insert into t_user(username, password, major, gender, userPhoto, hobby, regDate, ipAddress) values(?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sqlStatement);
			
			ps.setString(1, usernameReg);
			ps.setString(2, passwordReg);
			ps.setString(3, major);
			ps.setString(4, gender);
			ps.setString(5, fileName);
			ps.setString(6, userHobbies);
			ps.setString(7, regDate);
			ps.setString(8, ipAddr);
			
			//向数据库发送SQL语句
			ps.executeUpdate();
			
			//释放资源
			conn.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取所有用户的数据
	public static List<User> getAllUser(){
		
		//建立数据库连接
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils核心类，用来操作SQL语句
		QueryRunner runner = new QueryRunner();
		
		// 创建SQL语句
		String sqlStatement = "select * from t_user";
		
		List<User> allUsers = new ArrayList<>();
		try {
			
			//查询所有的用户数据，结果放入List<TUser>
			allUsers = runner.query(conn, sqlStatement, new BeanListHandler<User>(User.class));
			
			//释放资源
			DbUtils.closeQuietly(conn);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  allUsers;
	}
	
	//模糊查询所有用户的数据
	public static List<User> fuzzySearchUser(String key){
		
		//建立数据库连接
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils核心类，用来操作SQL语句
		QueryRunner runner = new QueryRunner();
		
		key = "%" + key + "%";
		
		//创建SQL语句
		String sqlStatement = "select * from t_user where username like ? or password like ? or gender like ? or major like ? or hobby like ?";
		
		List<User> users = new ArrayList<>();
		try {
			
			//查询所有的用户数据，结果放入List<TUser>
			users = runner.query(conn, sqlStatement, new BeanListHandler<User>(User.class), key, key, key, key, key);
			
			//释放资源
			DbUtils.closeQuietly(conn);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
		
	//根据id获取某一用户的详细信息
	public static User findUserById(int userId){
		
		//建立数据库连接
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils核心类
		QueryRunner runner = new QueryRunner();
		
		//创建SQL语句
		String sqlStatement = "select * from t_user where id=?";
		
		User user = null;
		
		try {
			//执行SQL语句
			 user = runner.query(conn, sqlStatement, new BeanHandler<User>(User.class), userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	//添加登录日志
	public static void addLog(String ipAddr, Date visitTime, String uri) {
		
		//建立数据库连接
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils核心类
		QueryRunner runner = new QueryRunner();
		
		String sqlStatement = "insert into t_log(ipAddr, visitTime, URI) values(?, ?, ?)";
		
		try {
			runner.execute(conn, sqlStatement, ipAddr, visitTime, uri);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//释放资源
		DbUtils.closeQuietly(conn);
	}
	
	//根据用户名精确查找用户
	public static User findExactUserByName(String username) {
		
		//建立数据库连接
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils核心类
		QueryRunner runner = new QueryRunner();
		
		//创建SQL语句
		String sqlStatement = "select * from t_user where username=?";
		
		User user = null;
		
		try {
			//执行SQL语句
			 user = runner.query(conn, sqlStatement, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//释放资源
		DbUtils.closeQuietly(conn);
		
		return user;
	}
	
}
