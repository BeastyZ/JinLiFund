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
 * ����������
 */

public class AllServices {

	// �������ݿ�����
	public static Connection getDBConnection() {

		Connection conn = null;

		// ע������
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// ׼��url���û���������
			String url = "JDBC:mysql://localhost:3306/db_180110910439?useUnicode=true&characterEncoding=utf-8";
			String user = "root";
			String password = "123456";

			// ��������
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	// ��ӹ˿�
	public static void addCustomer(String telephone, String password) throws SQLException {

		// �����ݿ⽨������
		Connection conn = getDBConnection();

		// ��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;

		// ��дSQL���
		String sqlStatement = "insert into t_customer(cusPhone, cusPassword) values(?, ?)";
		ps = conn.prepareStatement(sqlStatement);

		ps.setString(1, telephone);
		ps.setString(2, password);

		// �����ݿⷢ��SQL���
		ps.executeUpdate();

		// �ͷ���Դ
		conn.close();
		ps.close();

	}

	// �û���¼
	public static boolean login(String telephone, String password, String flag) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
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

	// ��ӵ�¼��־
	public static void addLog(String telephone, String ipAddr) {

		// �������ݿ�����
		Connection conn = getDBConnection();

		// ��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;

		// ��дSQL���
		String sqlStatement = "insert into t_log(telephone, ipAddress) values(?, ?)";

		try {
			ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, telephone);
			ps.setString(2, ipAddr);

			// �����ݿⷢ��SQL���
			ps.executeUpdate();

			// �ͷ���Դ
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// �û�����
	public static boolean findOne(String telephone) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
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

	// �û��������
	public static boolean updateCusPassword(String cusPhone, String newPassword) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			String sqlStatement = "update t_customer set cusPassword=? where cusPhone=?";

			// Ԥ�ö���
			PreparedStatement ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, newPassword);
			ps.setString(2, cusPhone);

			// ִ��sql��䣬����Ӱ������
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

	// У���˺ź������Ƿ���Ч
	public static boolean verifyCusPhonePassword(String cusPhone, String password) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
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

	// ���濪����Ϣ�����û����״̬���и��ģ���Ϊ�ɽ��л�����
	public static void saveOpenAccInfo(String cusPhone, String cusName, String cusIDNum, String cusCCNum,
			String cusPhoto) {

		// �������ݿ�����
		Connection conn = getDBConnection();

		// ��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;

		// ��дSQL���
		String sqlStatement = "update t_customer set cusName=?, cusIDNum=?, cusCCNum=?, cusStatus=? , cusPhoto=? where cusPhone=?";

		try {
			ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, cusName);
			ps.setString(2, cusIDNum);
			ps.setString(3, cusCCNum);
			ps.setInt(4, 1);// �����û�״̬
			ps.setString(5, cusPhoto);
			ps.setString(6, cusPhone);

			// �����ݿⷢ��SQL���
			ps.executeUpdate();

			// �ͷ���Դ
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// �ж��û��Ƿ񿪻�
	public static boolean verifyCusStatus(String cusPhone) {

		boolean result = false;
		Connection conn = null;

		try {
			conn = getDBConnection();// �������ݿ�����
			QueryRunner runner = new QueryRunner();// QueryRunner DbUtils�����࣬JavaBean
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

	// �û�ɾ��
	public static void deleteCus(String cusPhone) {

		// �������ݿ�����
		Connection conn = getDBConnection();

		// ��ȡ���������ݿⷢ��SQL����statement
		PreparedStatement ps = null;

		// ��дSQL���
		String sqlStatement = "delete from t_customer where cusPhone=?";

		try {
			ps = conn.prepareStatement(sqlStatement);
			ps.setString(1, cusPhone);

			// �����ݿⷢ��SQL���
			ps.executeUpdate();

			// �ͷ���Դ
			conn.close();
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	

}
