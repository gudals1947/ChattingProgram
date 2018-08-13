package ChattingSouce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBTest {
	Connection connection =  null;
	Statement st = null;
	
	public DBTest() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://210.119.85.217:3306/mysql","root","123123");
			st = connection.createStatement();
			System.out.println("성공");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
