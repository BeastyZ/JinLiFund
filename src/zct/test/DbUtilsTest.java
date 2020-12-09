package zct.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtilsTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//1.��������(ֻ��ע��һ�μ���)
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.���������ݿ������
		String url = "JDBC:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//3.��ȡ���������ݿⷢ��SQL����statement
		Statement st = conn.createStatement();
		
		//4.��дSQL���
		String sqlStatement = "select * from t_user";
		
		//5.�����ݿⷢ��SQL��䣬�����ز�ѯ���
		ResultSet rs = st.executeQuery(sqlStatement);
		
		//6.�ͷ���Դ
		conn.close();
		st.close();
		rs.close();
	}

}
