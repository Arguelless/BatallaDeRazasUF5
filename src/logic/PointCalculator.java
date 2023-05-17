package logic;

import playerClasses.Player;

public class PointCalculator implements BattlePoints{
	private String weaponName;
	private String enemyRace;
	
	public PointCalculator(Player enemy) {
		super();
		
		weaponName = enemy.getWeapon().getName();
		enemyRace = enemy.getRace();
	}
	
	public int calcPoints() {
		int points = 0;
		
		if(enemyRace.equals("Human")) {
			points += HUMAN;
			
		}else if(enemyRace .equals("Elf")) {
			points +=  ELF;
			
		}else {
			points += DWARF;
			
		}
		if(weaponName.equals("Dagger")) {
			points += DAGGER;
			
		}else if(weaponName.equals("Sword")) {
			points += SWORD;
			
		}else if(weaponName.equals("Axe")) {
			points += AXE;
			
		}else if(weaponName.equals("Double Swords")) {
			points += DOUBLESWORDS;
			
		}else if(weaponName.equals("Scimitarr")) {
			points += SCIMITAR;
			
		}else if(weaponName.equals("Bow")) {
			points += BOW;
			
		}else if(weaponName.equals("Katana")) {
			points += KATANA;
			
		}else if(weaponName.equals("Dirk")) {
			points += DIRK;
			
		}else {
			points += DOUBLEHANDEDAXE;
			
		}
		System.out.println(points);
		return points;
	}
}
