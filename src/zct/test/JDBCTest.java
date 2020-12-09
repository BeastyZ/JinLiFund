package zct.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) throws SQLException {
		
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//建立连接
			String url = "JDBC:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
			String user = "root";
			String password = "123456";
			Connection conn = DriverManager.getConnection(url, user, password);
			
			//创建执行SQL的语句
			Statement st = conn.createStatement();
//			String sql = "insert into t_user(username, password, gender) values('root', '123456', 'male')";
//			st.execute(sql);
			
			String sql = "select * from t_user where username='root' and password='123456'";
			
			ResultSet rs = st.executeQuery(sql);
			
			//释放资源
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
