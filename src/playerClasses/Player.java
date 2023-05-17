package playerClasses;

import java.sql.SQLException;

public class Player {
	private int warrior_id, health, power, speed, defense, agility;
	private int injuriesCaused;
	private int injuriesSuffered;
	private int points;
	private String name;
	private String race;
	private Weapon weapon;
	private Database data;
	private boolean human;
	
	// custom constructor used to assign the player's attributes and set its weapon of choice
	
	public Player(int warrior_id, boolean human) {
		super();
		
		data = new Database();
		this.warrior_id = warrior_id;
		this.human = human;
		
		setPlayerWarrior();
		setRacialStats();
	}
	
	// class constructor used to just get access to the database
	
	public Player() {
		super();
		
		data = new Database();
	}
	
	// method used to assign a weapon the player
	
	public void setWeapon(String name) {
		weapon = new Weapon(name, this);
		power += weapon.getPower();
		speed += weapon.getSpeed();
	}
	
	// method to get the weapon
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	// i made this method in case we need to remove the actual weapon of the player for some reason
	
	public void removeWeapon() {
		power -= weapon.getPower();
		speed -= weapon.getSpeed();
		weapon = null;
	}
	
	// method use to get the racial stats of the warrior from the database
	
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
	
	public void setPlayerWarrior() {
		String[] warrior = new String[2];
		
		try {
			warrior = data.getWarrior(warrior_id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		name = warrior[0];
		race = warrior[1];
	}
	
	// method used to return a randomly generated player
	
	public Player generateEnemy() {
		int id = (int)(Math.random()*data.getWarriorCount())+1;
		Player enemy = new Player(id, false);
		try {
			enemy.setWeapon(data.getWeaponAllStatNoID(data.getAvailableWeapons(id)[(int)(Math.random()*data.getAvailableWeapons(id).length)])[0]);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return enemy;
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
	
	public int getId() {
		return warrior_id;
	}
	
	public boolean getHuman() {
		return human;
	}
	
	public int getInjuriesCaused() {
		return injuriesCaused;
	}
	
	public void setInjuriesCaused(int injuries) {
		injuriesCaused += injuries;
	}
	
	public int getInjuriesSuffered() {
		return injuriesSuffered;
	}
	
	public void setInjuriesSuffered(int injuries) {
		injuriesSuffered += injuries;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points += points;
	}
	
	public String getRace() {
		return race;
	}

	@Override
	public String toString() {
		return "Player [warrior_id=" + warrior_id + ", health=" + health + ", power=" + power + ", speed=" + speed
				+ ", defense=" + defense + ", agility=" + agility + ", name=" + name + ", race=" + race + ", weapon="
				+ weapon + ", data=" + data + "]";
	}
}
