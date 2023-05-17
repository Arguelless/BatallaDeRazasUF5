package logic;

import javax.swing.JOptionPane;

import playerClasses.Player;
import windows.Fight_Window;
import windows.Starting_Window;

public class Fight {
	private Player player1, player2;
	private Player attacker;
	private Player defender;
	private Fight_Window window;
	private Player winner;
	private int round;
	
	public Fight(Player player1, Player player2, Fight_Window window) {
		this.player1 = player1;
		this.player2 = player2;
		this.window = window;
		round = 1;
		
		setFirstStrike();
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
		
		if(attacker.getHuman()) {
			player1.setInjuriesCaused(dmg);
			
		}else {
			player1.setInjuriesSuffered(dmg);
			
		}
		
		// first it checks if attacker agility is greater than a random integer between 1 and 100
		
		if(attacker.getAgility()*10>(int)(Math.random()*101)+1) {
			window.setTextPrint(attacker.getName() + " succesfully attacks");
			
			// then it determines whether or not the defender is able to dodge the attack
			
			if(attacker.getAgility()>(int)(Math.random()*51)+1) {
				window.setTextPrint(defender.getName() + " dodged the attack\n");
				
			}else {
				
				// if the attack did end up hitting, it checks if the attack damage is greater than 0 to
				// avoid returning negative values
				
				if(dmg>0) {
					window.setTextPrint(attacker.getName() + " deals "+dmg+" damage points"+"\n");
					
					return dmg;
				}
				window.setTextPrint(attacker.getName() + " deals "+0+" damage points" + "\n");
				
				return 0;
			}
			
		}else {
			window.setTextPrint(attacker.getName()+" missed the attack");
			
			// in case the attack misses it returns 0

		}
		return 0;
	}
	
	public void roleSwap() {
		Player aux;
		round += 1;
		
		if(attacker.getSpeed()>=defender.getSpeed()) {
			
			if(attacker.getSpeed() - (defender.getSpeed() * 10) > (int)(Math.random()*101)+1) {
				return;
			}
		}
		
		aux = defender;
		defender = attacker;
		attacker = aux;
		
		window.setRondas("Round "+round);
		
	}
	
	public void winEmergentWindow() {
        String[] options = {"Yes", "No"};
        int result = JOptionPane.showOptionDialog(null, "Do you want to keep fighting?", "Victory!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
        
        player1.setPoints(new PointCalculator(player2).calcPoints());
        
        if (result == JOptionPane.YES_OPTION) {
        	player1.setRacialStats();
        	player1.setWeapon(player1.getWeapon().getName());
        	
        	player2 = player2.generateEnemy();
        	
        	new Fight_Window(player1);
        	window.dispose();
        	
        } else if (result == JOptionPane.NO_OPTION) {
        	player1.getData().insertBattle(player1, player2);
        	
            window.dispose();
            
        }
    }
	
	public void looseEmergentWindow() {
        String[] options = {"Yes", "No"};
        int result = JOptionPane.showOptionDialog(null, "Do you want to keep fighting?", "Defeat!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
        
        player1.getData().insertBattle(player1, player2);
        
        if (result == JOptionPane.YES_OPTION) {
        	player1 = null;
        	player2 = null;
        	
        	new Starting_Window();
        	window.dispose();
        	
        } else if (result == JOptionPane.NO_OPTION) {
            window.dispose();
            
        }
    }
	
	// this method will be used to determine the output of each round, for now i use it to test the whole fight
	
	public void fight() {
		Player aux;
		int dmg;
		
		window.setTextPrint(attacker.getName()+" atacks" + "\n\n");
		
		dmg = atackDamage();
		defender.setHealth(defender.getHealth() - dmg);
		
		if(defender.getHealth()<=0) {
			winner = attacker;

		}
		else if(attacker.getHealth()<=0){
			winner = defender;
			
		}
		if(winner!=null) {
			window.setHp();
			
			window.setTextPrint(attacker.getName()+" won the fight!");
			
			if(winner.getHuman()) {
				winEmergentWindow();
				
			}else {
				looseEmergentWindow();
			}
		}
		
		roleSwap();
		
		window.setHp();
	}
}
