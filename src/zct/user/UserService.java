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
 * �û������࣬����ҵ���߼�
 */

public class UserService {
	
	//�������ݿ�����
	public static Connection getDBConnection() {
		
		Connection conn = null;
		
		//ע������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		//׼��url���û���������
		String url = "JDBC:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "123456";
		
		//��������
		conn = DriverManager.getConnection(url, user, password);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// �û���¼
	public static boolean login(String username, String password) {
		
		boolean result = false;
		Connection conn = null;
		List<User> users;
		
		try {
			conn = UserService.getDBConnection();//�������ݿ�����
			QueryRunner runner = new QueryRunner();//QueryRunner DbUtils�����࣬JavaBean
			
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
	
	//����û�
	public static void addUser(String usernameReg, String passwordReg, String major, String gender, String fileName, String userHobbies, String regDate, String ipAddr) {
		
		//�����ݿ⽨������
		Connection conn = UserService.getDBConnection();
		
		//��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;
		try {
			//��дSQL���
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
			
			//�����ݿⷢ��SQL���
			ps.executeUpdate();
			
			//�ͷ���Դ
			conn.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡ�����û�������
	public static List<User> getAllUser(){
		
		//�������ݿ�����
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils�����࣬��������SQL���
		QueryRunner runner = new QueryRunner();
		
		// ����SQL���
		String sqlStatement = "select * from t_user";
		
		List<User> allUsers = new ArrayList<>();
		try {
			
			//��ѯ���е��û����ݣ��������List<TUser>
			allUsers = runner.query(conn, sqlStatement, new BeanListHandler<User>(User.class));
			
			//�ͷ���Դ
			DbUtils.closeQuietly(conn);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return  allUsers;
	}
	
	//ģ����ѯ�����û�������
	public static List<User> fuzzySearchUser(String key){
		
		//�������ݿ�����
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils�����࣬��������SQL���
		QueryRunner runner = new QueryRunner();
		
		key = "%" + key + "%";
		
		//����SQL���
		String sqlStatement = "select * from t_user where username like ? or password like ? or gender like ? or major like ? or hobby like ?";
		
		List<User> users = new ArrayList<>();
		try {
			
			//��ѯ���е��û����ݣ��������List<TUser>
			users = runner.query(conn, sqlStatement, new BeanListHandler<User>(User.class), key, key, key, key, key);
			
			//�ͷ���Դ
			DbUtils.closeQuietly(conn);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
		
	//����id��ȡĳһ�û�����ϸ��Ϣ
	public static User findUserById(int userId){
		
		//�������ݿ�����
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils������
		QueryRunner runner = new QueryRunner();
		
		//����SQL���
		String sqlStatement = "select * from t_user where id=?";
		
		User user = null;
		
		try {
			//ִ��SQL���
			 user = runner.query(conn, sqlStatement, new BeanHandler<User>(User.class), userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	//��ӵ�¼��־
	public static void addLog(String ipAddr, Date visitTime, String uri) {
		
		//�������ݿ�����
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils������
		QueryRunner runner = new QueryRunner();
		
		String sqlStatement = "insert into t_log(ipAddr, visitTime, URI) values(?, ?, ?)";
		
		try {
			runner.execute(conn, sqlStatement, ipAddr, visitTime, uri);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//�ͷ���Դ
		DbUtils.closeQuietly(conn);
	}
	
	//�����û�����ȷ�����û�
	public static User findExactUserByName(String username) {
		
		//�������ݿ�����
		Connection conn = UserService.getDBConnection();
		
		//QueryRunner DbUtils������
		QueryRunner runner = new QueryRunner();
		
		//����SQL���
		String sqlStatement = "select * from t_user where username=?";
		
		User user = null;
		
		try {
			//ִ��SQL���
			 user = runner.query(conn, sqlStatement, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//�ͷ���Դ
		DbUtils.closeQuietly(conn);
		
		return user;
	}
	
}
