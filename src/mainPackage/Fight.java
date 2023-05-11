package mainPackage;

public class Fight {
	private Player player1, player2;
	private Player attacker;
	private Player defender;
	
	public void setEnemy() {
		player2 = new Player(4);
		player2.setWeapon("Sword");
		
		System.out.println(player2.toString());
	}
	
	public void setPlayer() {
		player1 = new Player(5);
		player1.setWeapon("Bow");
		
		System.out.println(player1.toString());
	}
	
	// this method is used to establish the initial attacker
	
	public void setFirstStrike() {
		
		// first it compares speed
		
		if(player1.getSpeed() > player2.getSpeed()) {
			attacker = player1;
			defender = player2;
		}
		else if(player1.getSpeed() < player2.getSpeed()) {
			attacker = player2;
			defender = player1;
		}
		
		// then it compares agility
		
		else if(player1.getAgility() > player2.getAgility()){
			attacker = player1;
			defender = player2;
		}
		else if(player1.getAgility() < player2.getAgility()){
			attacker = player2;
			defender = player1;
		}
		
		// finally if we got here, it is a coin flip between the two 
		
		else {
			if((int) (Math.random()*2)==0) {
				attacker = player1;
				defender = player2;
			}
			else {
				attacker = player2;
				defender = player1;
			}
		}
	}
	
	// this method makes the damage output calculations of the attacker
	
	public int atackDamage() {
		int dmg = attacker.getPower() - defender.getDefense();
		
		// first it checks if attacker agility is greater than a random integer between 1 and 100
		
		if(attacker.getAgility()*10>(int)(Math.random()*101)+1) {
			System.out.println(attacker.getName() + " succesfully attacks");
			
			// then it determines whether or not the defender is able to dodge the attack
			
			if(attacker.getAgility()>(int)(Math.random()*51)+1) {
				System.out.println(defender.getName() + " dodged the attack");
			}else {
				
				// if the attack did end up hitting, it checks if the attack damage is greater than 0 to
				// avoid returning negative values
				
				if(dmg>0) {
					System.out.println(attacker.getName() + " deals "+dmg+" damage points"+"\n");
					return dmg;
				}
				System.out.println(attacker.getName() + " deals "+0+" damage points" + "\n");
				return 0;
			}
		}
		
		// in case the attack misses it returns 0
		
		System.out.println(attacker.getName()+" missed the attack");
		return 0;
	}
	
	// this method will be used to determine the output of each round, for now i use it to test the whole fight
	
	public void fight() {
		Player aux;
		int dmg;
		
		while(player1.getHealth()>0&&player2.getHealth()>0) {
			System.out.println(attacker.getName()+" atacks" + "\n\n");
			dmg = atackDamage();
			defender.setHealth(defender.getHealth() - dmg);
			aux = attacker;
			attacker = defender;
			defender = aux;
			
			if(defender.getHealth()<=0) {
				System.out.println(attacker.getName()+" won the fight!");
			}
			else if(attacker.getHealth()<=0){
				System.out.println(defender.getName()+" won the fight!");
			}
		}
	}
	
	// just for testing
	
	public static void main(String[] args) {
		Fight fight = new Fight();
		fight.setPlayer();
		fight.setEnemy();
		fight.setFirstStrike();
		fight.fight();
	}
}
