package mainPackage;

public class Weapon {
	private int power;
	private int speed;
	private int defense;
	
	// custom constructor used to assign the weapon's stats
	
	public Weapon(int power, int speed, int defense) {
		super();
		this.power = power;
		this.speed = speed;
		this.defense = defense;
	}
	
	// getters and setters
	
	public int getPower() {
		return power;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDefense() {
		return defense;
	}
}
