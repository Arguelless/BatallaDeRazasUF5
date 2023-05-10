package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
	private String url;
	private String user;
	private String psw;
	private Connection con;
	private String query;
	
	// Ths methods establishes a connection with the database
	
	public Database() {
		super();
		
		url = "jdbc:mysql://localhost/BDDbatalla?serverTimezone=UTC";
		user = "root";
		psw = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, psw);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	// Method that returns the stats of the desired weapon
	
	public int[] getWeaponStats(String weaponName) throws SQLException {
		int power = 0;
		int speed = 0;
		query = "select weapon_speed, weapon_power from weapons where weapon_name = ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, weaponName);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			power = rs.getInt(2);
			speed = rs.getInt(1);
			
		}
		
		return new int[] {speed, power};
	}
	
	// same as previous method but in this case it returns the racial stats of a certain race
	
	public int[] getRaceStats(String raceName) throws SQLException {
		int health = 0;
		int power = 0;
		int defense = 0;
		int agility = 0;
		int speed = 0;
		query = "select health, power, defense, agility, speed from races where race_name = ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, raceName);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			health = rs.getInt(1);
			power = rs.getInt(2);
			defense = rs.getInt(3);
			agility = rs.getInt(4);
			speed = rs.getInt(5);
			
		}
		
		return new int[] {health, power, defense, agility, speed};
	}
	
	// This method returns an array that contains all the id's of the weapons
	// available for the designated race
	
	public int[] getAvailableWeapons(int warriorId) throws SQLException{
		ArrayList<Integer> weapons = new ArrayList<Integer>();
		
		query = "select weapon_id from weapons_available where warrior_id = ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, warriorId);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			weapons.add(rs.getInt(1));
		}
		
		// I dont want to be dealing with an ArrayList so i convert it to a regular Array
		
		int[] weaponsArray = new int[weapons.size()];
		
		for(int i=0;i<weapons.size();i++) {
			weaponsArray[i] = weapons.get(i);
		}
		
		return weaponsArray;
	}
	
	// method that gets both the name and race of the choosen warrior
	
	public String[] getWarrior(int warriorId) throws SQLException {
		String warrior[] = new String[2];
		
		query = "select warrior_name, race_name from warriors join races on race_id = warrior_race where warrior_id = ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, warriorId);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			warrior[0] = (rs.getString(1));
			warrior[1] = (rs.getString(2));
		}
		
		return warrior;
	}
	
	public static void main(String[] args) {
		Database bd = new Database();
		String datos[];
		try {
			datos = bd.getWarrior(7);
			System.out.println(datos[0] + "  " + datos[1]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
