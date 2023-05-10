package mainPackage;

import java.sql.SQLException;

public class Player {
	private int health;
	private int power;
	private int speed;
	private int defense;
	private int agility;
	private String name;
	private String race;
	private Weapon weapon;
	private Database data;
	
	// custom constructor used to assign the player's attributes and set its weapon of choice
	
	public Player(String name, String race) {
		super();
		
		this.name = name;
		this.race = race;
		data = new Database();
		
		setRacialStats();
	}
	
	// method used to assign a weapon the player, for now it generates a random one
	
	public void setWeapon(String name) {
		weapon = new Weapon(name, this);
		power += weapon.getPower();
		speed += weapon.getSpeed();
		defense += weapon.getSpeed();
	}
	
	// i made this method in case we need to remove the actual weapon of the player for some reason
	
	public void removeWeapon() {
		power -= weapon.getPower();
		speed -= weapon.getSpeed();
		defense = weapon.getSpeed();
		weapon = null;
	}
	
	public void setRacialStats() {
		int[] stats = new int[5];
		
		try {
			stats = data.getRaceStats(race);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		health = stats[0];
		power = stats[1];
		defense = stats[2];
		agility = stats[3];
		speed = stats[4];
	}
	
	// getters and setters
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getAgility() {
		return agility;
	}
	
	public String getName() {
		return name;
	}
	
	public Database getData() {
		return data;
	}
}
