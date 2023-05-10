package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private String url;
	private String user;
	private String psw;
	private Connection con;
	private String query;
	
	public Database() {
		super();
		url = "jdbc:mysql://localhost/BDDbatalla?serverTimezone=UTC";
		user = "root";
		psw = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, psw);
			
			System.out.println("connection established!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getWeapon(String weaponName) throws SQLException {
		int power;
		
		query = "select weapon_speed from weapons where weapon_name = ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, weaponName);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			power = rs.getInt(1);
			System.out.println(rs.getInt(1));
		}
	}
	public static void main(String[] args) {
		Database bd = new Database();
		try {
			bd.getWeapon("Daga");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
