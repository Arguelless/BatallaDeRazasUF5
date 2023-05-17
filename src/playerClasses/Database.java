package playerClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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
	     psw = "X9883835r";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, psw);
			//createTables();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	public void createTables(){

        // It uses the ProcessBuilder class to execute a mysql order in the system command line.

        ProcessBuilder pb = new ProcessBuilder("mysql", "-u", user, "-p" + psw);
        File file = new File("./src/mainPackage/base de datos.sql");
        pb.redirectInput(file);

        try {
            Process process = pb.start();
            int exitCode = process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

        }

        // It checks if the database contains any weapon so it can insert the data in case
        // is needed

        query = "select count(*) from weapons;";

        try {
            con.createStatement().executeUpdate("use BDDbatalla;");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            rs.next();

            if(rs.getInt(1)==0) {
                pb = new ProcessBuilder("mysql", "-u", user, "-p" + psw, "BDDbatalla", "-e", "source ./src/mainPackage/scriptArmas.sql");

                try {
                    Process process = pb.start();
                    int exitCode = process.waitFor();

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

	// Method that returns all data of battle table
	
	public int getRankingTotal() throws SQLException {
		int total=0;
		
		query = "select count(*) from battle";
		
		PreparedStatement st = con.prepareStatement(query);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {	
			total = rs.getInt(1);
		}
		
		return total;
	}
	
	// Method that returns all data of battle table
	
	public int[] getRanking(int BattleID) throws SQLException {
		int p_id=0;
		int warrior_id=0;
		int battle_points=0;
		
		query = "select player_id, warrior_id, battle_points from battle where battle_id= ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, BattleID);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {	
			p_id = rs.getInt(1);
			warrior_id = rs.getInt(2);
			battle_points=rs.getInt(3);
		}
		
		return new int[] {p_id, warrior_id,battle_points};
	}
	
	// Method that returns the stats of the desired weapon
	
	public int[] getWeaponStats(String weaponName) throws SQLException {
		int power = 0;
		int speed = 0;
		int id =0;
		query = "select weapon_speed, weapon_power, weapon_id from weapons where weapon_name = ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, weaponName);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {	
			power = rs.getInt(2);
			speed = rs.getInt(1);
			id=rs.getInt(3);
		}
		
		return new int[] {speed, power,id};
	}
	
	public String[] getWeaponAllStatNoID(int ID) throws SQLException {
		int power = 0;
		int speed = 0;
		String weapon_name="";
		String weapon_image_path="";
		query = "select weapon_name, weapon_image_path from weapons where weapon_id = ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, ID);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		weapon_name=rs.getString(1);
		weapon_image_path=rs.getString(2);
			
		return new String[] {weapon_name, weapon_image_path};
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
		String warrior[] = new String[3];
		
		query = "select  warrior_name, race_name,warrior_image_path from warriors join races on race_id = warrior_race where warrior_id = ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, warriorId);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		warrior[0] = (rs.getString(1));
		warrior[1] = (rs.getString(2));
		warrior[2] =(rs.getString(3));
		
		return warrior;
	}
	
	public int getWarriorID(String warriorname) throws SQLException {
		int IDwarrior=0;
		
		query = "select  warrior_id from warriors where warrior_name = ?";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, warriorname);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			IDwarrior=rs.getInt(1);
		}
		
		return IDwarrior;
	}
	
	public int getWarriorCount() {
		int res = 0;
		query = "select count(*) from warriors;";
		
		ResultSet rs;
		
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			rs.next();
			res = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return res;
	}
	
	public String getWeaponImage(String weapon_name) {
		String res = "";
		
		query = "select weapon_image_path from weapons where weapon_name = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, weapon_name);
			
			ResultSet rs = st.executeQuery();
			
			rs.next();
			
			res = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		return res;
	}
	
	public int insertPlayer(Player player) {
		String name = player.getName();
		int id = 0;
		
		query = "insert into players (player_name) values(?)";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			
			st.executeUpdate();
			
			query = "select max(player_id) from players;";
			
			st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			
			rs.next();
			id = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return id;
	}
	
	public void insertBattle(Player player, Player enemy) {
		int player_id = insertPlayer(player);
		int enemy_id = insertPlayer(enemy);
		int warrior_id = player.getId();
		int injuriesCaused = player.getInjuriesCaused();
		int injuriesSuffered = player.getInjuriesSuffered();
		int points = player.getPoints();
		
		try {
			int warrior_weapon_id = player.getData().getWeaponStats(player.getWeapon().getName())[2];
			int enemy_weapon_id = enemy.getData().getWeaponStats(enemy.getWeapon().getName())[2];
			
			query = "insert into battle (player_id, warrior_id, warrior_weapon_id, opponent_id, opponent_weapon_id,"
					+ "injuries_caused, injuries_suffered, battle_points) values (?, ?, ?, ?, ? ,?, ?, ?)";
			
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, player_id);
			st.setInt(2, warrior_id);
			st.setInt(3, warrior_weapon_id);
			st.setInt(4, enemy_id);
			st.setInt(5, enemy_weapon_id);
			st.setInt(6, injuriesCaused);
			st.setInt(7, injuriesSuffered);
			st.setInt(8, points);
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
}
