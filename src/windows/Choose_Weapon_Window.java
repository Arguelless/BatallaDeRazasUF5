package windows;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import playerClasses.Player;
import playerClasses.Weapon;

public class Choose_Weapon_Window extends JFrame{
	private BufferedImage icon, image;
	private JPanel mainPanel;
	private JPanel imagePanels[];
	private JPanel panels[];
	private Player player;
	private JButton buttons[];
	
	// the constructor requires a player so it can get the available weapons for that character
	
	public Choose_Weapon_Window(Player player) {
		super();
		
		this.player = player;
		System.out.println(player.toString());
		
		frameParameters();
		setupPanels();
		
		this.setVisible(true);
	}
	
	// method that adds the window's icon
	
	public void loadIcon() {
		try {
			icon = ImageIO.read(new File("./src/Images/Game_icon.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	// method that sets the frame properties
	
	public void frameParameters() {
		setTitle("Races Fight");
		setSize(1000, 800);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        
	}
	
	// method that sets and adds the panels
	
	public void setupPanels() {
		int weaponCount;
		int weapons[];
		
		try {
			
			// gets a lists of the id's of the weapons available for the chosen character
			
			weapons = player.getData().getAvailableWeapons(player.getId());
			
		} catch (SQLException e) {
			weapons = new int[1];
			e.printStackTrace();
			
		}
		
		// stores the length of the weapons list
		
		weaponCount = weapons.length;
		
		mainPanel = new JPanel();
		buttons = new JButton[weaponCount];
		
		// makes the main panel have a grid layout of 3 columns and number of weapons/columns rows
		
		mainPanel.setLayout(new GridLayout((int)(Math.ceil(weaponCount)/3), 3, 0, 20));
		
		imagePanels = new JPanel[weaponCount];
		panels = new JPanel[weaponCount];
		
		// iterates through the weapon id list while defining the panels and buttons of the weapons
		
		for(int i=0;i<weaponCount;i++) {
			try {
				imagePanels[i] = new ImagePanel(player.getData().getWeaponAllStatNoID(weapons[i])[1]);
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			panels[i] = new JPanel();
			
			panels[i].setLayout(new BorderLayout());
			
			try {
				String name =player.getData().getWeaponAllStatNoID(weapons[i])[0];
				buttons[i] = new JButton(name);
				buttons[i].addActionListener(new ActionListener() {
					
					// adds an Action Listener for each button to track which weapon is chosen
					
					public void actionPerformed(ActionEvent e) {
						player.setWeapon(name);
						new Starting_Window(player);
						
						dispose();
					}
					
				});
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			
			panels[i].add(imagePanels[i], BorderLayout.CENTER);
			panels[i].add(buttons[i], BorderLayout.NORTH);
			
			mainPanel.add(panels[i]);
			
		}
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(mainPanel);
			
	}

}
