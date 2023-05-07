package mainPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class Class {

}

class Characters {
	private String race;
	private int health;
	private int strength;
	private int defence;
	private int agility;
	private int speed;
	
	
	
	
	@Override
	public String toString() {
		return "Characters [race=" + race + ", health=" + health + ", strength=" + strength + ", defence=" + defence
				+ ", agility=" + agility + ", speed=" + speed + "]";
	}
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
	//[0]=velocitat, [1]=Força
	private ArrayList<Integer> description;
	//[0]=Huma, [1]=Elf, [2]=Nan
	private ArrayList<String> race_use;
	
	
	public Weapons(String weapon, ArrayList<Integer> description, ArrayList<String> race_use) {
		super();
		this.weapon = weapon;
		this.description = description;
		this.race_use = race_use;
	}
	
	
	@Override
	public String toString() {
		return "Weapons [weapon=" + weapon + ", description=" + description + ", race_use=" + race_use + "]";
	}


	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public ArrayList<Integer> getDescription() {
		return description;
	}
	public void setDescription(ArrayList<Integer> description) {
		this.description = description;
	}
	public ArrayList<String> getRace_use() {
		return race_use;
	}
	public void setRace_use(ArrayList<String> race_use) {
		this.race_use = race_use;
	}
	
}


class Datos{
	public Datos() {
		super();
	}
	//Mas a delante esto tiene que estar en bbdd
	ArrayList<Characters> charactersList = new ArrayList<>(Arrays.asList(
		    new Characters("Nan", 60, 6, 4, 5, 3),
		    new Characters("Humà", 50, 5, 3, 6, 5),
		    new Characters("Elf", 40, 4, 2, 7, 7)
		));

	ArrayList<Weapons> weaponsList = new ArrayList<>(Arrays.asList(
		    new Weapons("Daga", new ArrayList<Integer>(Arrays.asList(3,0)), new ArrayList<String>(Arrays.asList("Humà","Elf",null))),
		    new Weapons("Espasa", new ArrayList<Integer>(Arrays.asList(1,1)), new ArrayList<String>(Arrays.asList("Humà","Elf","Nan"))),
		    new Weapons("Destral", new ArrayList<Integer>(Arrays.asList(0,3)), new ArrayList<String>(Arrays.asList("Humà",null,"Nan"))),
		    new Weapons("Espases dobles", new ArrayList<Integer>(Arrays.asList(2,2)), new ArrayList<String>(Arrays.asList("Humà","Elf",null))),
		    new Weapons("Simitarra", new ArrayList<Integer>(Arrays.asList(2,1)), new ArrayList<String>(Arrays.asList("Humà","Elf",null))),
		    new Weapons("Arc", new ArrayList<Integer>(Arrays.asList(5,1)), new ArrayList<String>(Arrays.asList(null,"Elf",null))),
		    new Weapons("Katana", new ArrayList<Integer>(Arrays.asList(3,2)), new ArrayList<String>(Arrays.asList("Humà",null,null))),
		    new Weapons("Punyal", new ArrayList<Integer>(Arrays.asList(4,0)), new ArrayList<String>(Arrays.asList("Humà","Elf","Nan"))),
		    new Weapons("Destral de dues mans", new ArrayList<Integer>(Arrays.asList(0,5)), new ArrayList<String>(Arrays.asList(null,null,"Nan")))
		));

	public ArrayList<Characters> getCharactersList() {
		return charactersList;
	}

	public void setCharactersList(ArrayList<Characters> charactersList) {
		this.charactersList = charactersList;
	}

	public ArrayList<Weapons> getWeaponsList() {
		return weaponsList;
	}

	public void setWeaponsList(ArrayList<Weapons> weaponsList) {
		this.weaponsList = weaponsList;
	}
	
	
	
	
	
	
}
