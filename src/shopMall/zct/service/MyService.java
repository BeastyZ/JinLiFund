package shopMall.zct.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import shopMall.zct.servlet.sellers.Seller;

/*
 * ������
 */
public class MyService {
	
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
		
		//�����û��������뾫ȷ��������
		public static Seller findSeller(String username, String password) {
			
			//�������ݿ�����
			Connection conn = MyService.getDBConnection();
			
			//QueryRunner DbUtils������
			QueryRunner runner = new QueryRunner();
			
			//����SQL���
			String sqlStatement = "select * from t_sellers where username=? and password=?";
			
			Seller seller = null;
			
			try {
				//ִ��SQL���
				 seller = runner.query(conn, sqlStatement, new BeanHandler<Seller>(Seller.class), username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//�ͷ���Դ
			DbUtils.closeQuietly(conn);
			
			return seller;
		}
}
