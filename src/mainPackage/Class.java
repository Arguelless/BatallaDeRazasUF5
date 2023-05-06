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
	private Characters enano=new Characters("Nan", 60, 6, 4, 5, 3);
	private Characters humano=new Characters("Humà", 50, 5, 3, 6, 5);
	private Characters elfo=new Characters("Elf", 40, 4, 2, 7, 7);
	private Weapons daga=new Weapons("Daga", new ArrayList<Integer>(Arrays.asList(3,0)), new ArrayList<String>(Arrays.asList("Huma","Elf",null)));
	private Weapons espasa=new Weapons("Espasa", new ArrayList<Integer>(Arrays.asList(1,1)), new ArrayList<String>(Arrays.asList("Huma","Elf","Nan")));
	private Weapons destral=new Weapons("Destral", new ArrayList<Integer>(Arrays.asList(0,3)), new ArrayList<String>(Arrays.asList("Huma",null,"Nan")));
	private Weapons espases_dobles=new Weapons("Espases dobles", new ArrayList<Integer>(Arrays.asList(2,2)), new ArrayList<String>(Arrays.asList("Huma","Elf",null)));
	private Weapons simitarra=new Weapons("Simitarra", new ArrayList<Integer>(Arrays.asList(2,1)), new ArrayList<String>(Arrays.asList("Huma","Elf",null)));
	private Weapons arc=new Weapons("Arc", new ArrayList<Integer>(Arrays.asList(5,1)), new ArrayList<String>(Arrays.asList(null,"Elf",null)));
	private Weapons katana=new Weapons("katana", new ArrayList<Integer>(Arrays.asList(3,2)), new ArrayList<String>(Arrays.asList("Huma",null,null)));
	private Weapons punyal=new Weapons("Punyal", new ArrayList<Integer>(Arrays.asList(4,0)), new ArrayList<String>(Arrays.asList("Huma","Elf","Nan")));
	private Weapons destral_de_dues_mans=new Weapons("Destral de dues mans", new ArrayList<Integer>(Arrays.asList(0,5)), new ArrayList<String>(Arrays.asList(null,null,"Nan")));
	public Characters getEnano() {
		return enano;
	}
	public void setEnano(Characters enano) {
		this.enano = enano;
	}
	public Characters getHumano() {
		return humano;
	}
	public void setHumano(Characters humano) {
		this.humano = humano;
	}
	public Characters getElfo() {
		return elfo;
	}
	public void setElfo(Characters elfo) {
		this.elfo = elfo;
	}
	public Weapons getDaga() {
		return daga;
	}
	public void setDaga(Weapons daga) {
		this.daga = daga;
	}
	public Weapons getEspasa() {
		return espasa;
	}
	public void setEspasa(Weapons espasa) {
		this.espasa = espasa;
	}
	public Weapons getDestral() {
		return destral;
	}
	public void setDestral(Weapons destral) {
		this.destral = destral;
	}
	public Weapons getEspases_dobles() {
		return espases_dobles;
	}
	public void setEspases_dobles(Weapons espases_dobles) {
		this.espases_dobles = espases_dobles;
	}
	public Weapons getSimitarra() {
		return simitarra;
	}
	public void setSimitarra(Weapons simitarra) {
		this.simitarra = simitarra;
	}
	public Weapons getArc() {
		return arc;
	}
	public void setArc(Weapons arc) {
		this.arc = arc;
	}
	public Weapons getKatana() {
		return katana;
	}
	public void setKatana(Weapons katana) {
		this.katana = katana;
	}
	public Weapons getPunyal() {
		return punyal;
	}
	public void setPunyal(Weapons punyal) {
		this.punyal = punyal;
	}
	public Weapons getDestral_de_dues_mans() {
		return destral_de_dues_mans;
	}
	public void setDestral_de_dues_mans(Weapons destral_de_dues_mans) {
		this.destral_de_dues_mans = destral_de_dues_mans;
	}

	
	
	
	
	
}
