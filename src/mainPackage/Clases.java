package mainPackage;

public class Clases {

}

class Characters {
	private String race;
	private int health;
	private int strength;
	private int defence;
	private int agility;
	private int speed;
	
	
	
	
	public Characters(String race, int health, int strength, int defence, int agility, int speed) {
		super();
		this.race = race;
		this.health = health;
		this.strength = strength;
		this.defence = defence;
		this.agility = agility;
		this.speed = speed;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}

class Weapons{
	private String weapon;
	private String description;
	private String race_use;
	public Weapons(String weapon, String description, String race_use) {
		super();
		this.weapon = weapon;
		this.description = description;
		this.race_use = race_use;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRace_use() {
		return race_use;
	}
	public void setRace_use(String race_use) {
		this.race_use = race_use;
	}
	
	
	
	
}