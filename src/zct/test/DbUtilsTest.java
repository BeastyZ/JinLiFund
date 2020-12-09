package zct.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtilsTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//1.加载驱动(只需注册一次即可)
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.建立与数据库的连接
		String url = "JDBC:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//3.获取用于向数据库发送SQL语句的statement
		Statement st = conn.createStatement();
		
		//4.编写SQL语句
		String sqlStatement = "select * from t_user";
		
		//5.向数据库发送SQL语句，并返回查询结果
		ResultSet rs = st.executeQuery(sqlStatement);
		
		//6.释放资源
		conn.close();
		st.close();
		rs.close();
	}

}
