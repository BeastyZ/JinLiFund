package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/*
 * 公共服务类
 */

public class AllServices {

	// 建立数据库连接
	public static Connection getDBConnection() {

		Connection conn = null;

		// 注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 准备url、用户名、密码
			String url = "JDBC:mysql://localhost:3306/db_180110910439?useUnicode=true&characterEncoding=utf-8";
			String user = "root";
			String password = "123456";

			// 建立连接
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	// 添加顾客
	public static void addCustomer(String telephone, String password) throws SQLException {

		// 与数据库建立连接
		Connection conn = getDBConnection();

		// 获取用于向数据库发送SQL语句的statement
		PreparedStatement ps = null;

		// 编写SQL语句
		String sqlStatement = "insert into t_customer(cusPhone, cusPassword) values(?, ?)";
		ps = conn.prepareStatement(sqlStatement);

		ps.setString(1, telephone);
		ps.setString(2, password);

		// 向数据库发送SQL语句
		ps.executeUpdate();

		// 释放资源
		conn.close();
		ps.close();

	}

	// 用户登录
	public static boolean login(String telephone, String password, String flag) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// 建立数据库连接
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils核心类，JavaBean
			String sqlStatement;

			if ("customer".equals(flag)) {
				sqlStatement = "select * from t_customer where cusPhone=? and cusPassword=?";
				Customer customer = runner.query(conn, sqlStatement, new BeanHandler<Customer>(Customer.class),
						telephone, password);

				if (customer != null) {
					result = true;
				}
			} else {
				sqlStatement = "select * from t_administrator where admPhone=? and admPassword=?";
				Administrator administrator = runner.query(conn, sqlStatement,
						new BeanHandler<Administrator>(Administrator.class), telephone, password);

				if (administrator != null) {
					result = true;
				}
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 添加登录日志
	public static void addLog(String telephone, String ipAddr) {

		// 建立数据库连接
		Connection conn = getDBConnection();

		// 获取用于向数据库发送SQL语句的statement
		PreparedStatement ps = null;

		// 编写SQL语句
		String sqlStatement = "insert into t_log(telephone, ipAddress) values(?, ?)";

		try {
			ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, telephone);
			ps.setString(2, ipAddr);

			// 向数据库发送SQL语句
			ps.executeUpdate();

			// 释放资源
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// 用户查找
	public static boolean findOne(String telephone) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// 建立数据库连接
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils核心类，JavaBean
			String sqlStatement;

			sqlStatement = "select * from t_customer where cusPhone=?";
			Customer customer = runner.query(conn, sqlStatement, new BeanHandler<Customer>(Customer.class), telephone);

			if (customer != null) {
				result = true;
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 用户密码更新
	public static boolean updateCusPassword(String cusPhone, String newPassword) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// 建立数据库连接
			String sqlStatement = "update t_customer set cusPassword=? where cusPhone=?";

			// 预置对象
			PreparedStatement ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, newPassword);
			ps.setString(2, cusPhone);

			// 执行sql语句，返回影响行数
			int res = ps.executeUpdate();

			if (res > 0) {
				result = true;
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 校验账号和密码是否有效
	public static boolean verifyCusPhonePassword(String cusPhone, String password) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// 建立数据库连接
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils核心类，JavaBean
			String sqlStatement;

			sqlStatement = "select * from t_customer where cusPhone=? and cusPassword=?";
			Customer customer = runner.query(conn, sqlStatement, new BeanHandler<Customer>(Customer.class), cusPhone,
					password);

			if (customer != null) {
				result = true;
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 保存开户信息并对用户身份状态进行更改，改为可进行基金交易
	public static void saveOpenAccInfo(String cusPhone, String cusName, String cusIDNum, String cusCCNum,
			String cusPhoto) {

		// 建立数据库连接
		Connection conn = getDBConnection();

		// 获取用于向数据库发送SQL语句的statement
		PreparedStatement ps = null;

		// 编写SQL语句
		String sqlStatement = "update t_customer set cusName=?, cusIDNum=?, cusCCNum=?, cusStatus=? , cusPhoto=? where cusPhone=?";

		try {
			ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, cusName);
			ps.setString(2, cusIDNum);
			ps.setString(3, cusCCNum);
			ps.setInt(4, 1);// 改修用户状态
			ps.setString(5, cusPhoto);
			ps.setString(6, cusPhone);

			// 向数据库发送SQL语句
			ps.executeUpdate();

			// 释放资源
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// 判断用户是否开户
	public static boolean verifyCusStatus(String cusPhone) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// 建立数据库连接
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils核心类，JavaBean
			String sqlStatement;

			sqlStatement = "select * from t_customer where cusPhone=?";
			Customer customer = runner.query(conn, sqlStatement, new BeanHandler<Customer>(Customer.class), cusPhone);

			if (customer.getCusStatus() == 1) {
				result = true;
			}

			DbUtils.closeQuietly(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 用户删除
	public static void deleteCus(String cusPhone) {

		// 建立数据库连接
		Connection conn = getDBConnection();

		// 获取用于向数据库发送SQL语句的statement
		PreparedStatement ps = null;

		// 编写SQL语句
		String sqlStatement = "delete from t_customer where cusPhone=?";

		try {
			ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, cusPhone);

			// 向数据库发送SQL语句
			ps.executeUpdate();

			// 释放资源
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	

}
