package mainPackage;

import java.sql.SQLException;
import java.util.Arrays;

public class Weapon {
	private String name;
	private int stats[];
	private int power;
	private int speed;
	private Player player;
	
	// custom constructor used to assign the weapon's stats
	
	public Weapon(String name, Player player) {
		super();
		
		this.name = name;
		this.player = player;
		setStats();
	}
	
	// getters and setters
	
	public int getPower() {
		return power;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	// Method used to get the power and speed values of the weapon
	
	public void setStats() {
		stats = new int[2];
		
		try {
			stats = player.getData().getWeaponStats(name);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		this.power = stats[1];
		this.speed = stats[0];
		
	}

	
}
