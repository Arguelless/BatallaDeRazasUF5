package mainPackage;

public class Player {
	private int health;
	private int power;
	private int speed;
	private int defense;
	private int agility;
	private String name;
	private Weapon weapon;
	
	// custom constructor used to assign the player's attributes and set its weapon of choice
	
	public Player(int health, int power, int speed, int agility, int defense, String name) {
		this.health = health;
		this.power = power;
		this.speed = speed;
		this.agility = agility;
		this.defense = defense;
		this.name = name;
		setWeapon();
	}
	
	// method used to assign a weapon the player, for now it generates a random one
	
	public void setWeapon() {
		weapon = new Weapon((int) (Math.random()*10), (int) (Math.random()*10), (int) (Math.random()*10));
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
}
