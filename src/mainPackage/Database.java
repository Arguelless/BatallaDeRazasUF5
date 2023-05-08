package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private String url;
	private String user;
	private String psw;
	
	public Database() {
		super();
		url = "jdbc:mysql://localhost/BDDbatalla?serverTimezone=UTC";
		user = "root";
		psw = "1234";
	}
	
	// planed on using this for connecting to the mysqlDB and to store each race and weapon type attributes
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, psw);
			
			System.out.println("connection established!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Database bd = new Database();
		bd.connectDB();
	}
}
