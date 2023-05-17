package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
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

public class Choose_Character_Window extends JFrame {
	private BufferedImage icon, image;
	private JPanel mainPanel;
	private JPanel imagePanels[];
	private JPanel panels[];
	private Player player;
	private JButton buttons[];
	
	// constructor requires Player instance so it can access the database
	
	public Choose_Character_Window(Player player) {
		super();
		this.player = player;

		frameParameters();
		setupPanels();
		
		this.setVisible(true);
		
	}
	
	// method that sets the window icon
	
	public void loadIcon() {
		try {
			icon = ImageIO.read(new File("./src/Images/Game_icon.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	// method that sets the window properties
	
	public void frameParameters() {
		setTitle("Races Fight");
		setSize(1000, 800);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        
	}
	
	// method that sets the panels layouts and components
	
	public void setupPanels() {
		
		// stores the amount of warriors in the database through a Database class method
		
		int warriorCount = player.getData().getWarriorCount();
		
		mainPanel = new JPanel();
		
		// defines the amount of buttons as the amount of warriors
		
		buttons = new JButton[warriorCount];
		
		// sets a GridLayout for the main panel, it determines the amount of rows by dividing
		// the amount of warriors between the number of columns
		
		mainPanel.setLayout(new GridLayout((int)(Math.ceil(warriorCount)/3), 3, 0, 20));
		
		imagePanels = new JPanel[warriorCount];
		panels = new JPanel[warriorCount];
		
		// iterates through the number of warriors
		// each iteration sets a panel which contains an image panel and a button, then adds it to the main panel
		
		for(int i=1;i<=warriorCount;i++) {
			imagePanels[i-1] = new ImagePanel(i, player);
			panels[i-1] = new JPanel();
			
			panels[i-1].setLayout(new BorderLayout());
			
			try {
				int id = i;
				buttons[i-1] = new JButton(player.getData().getWarrior(i)[0]);
				buttons[i-1].addActionListener(new ActionListener() {

					// this adds an Action Listener to each button that is used to track
					// which characters is chosen
					
					public void actionPerformed(ActionEvent e) {
						player = new Player(id, true);
						new Starting_Window(player);
						
						dispose();
					}
					
				});
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			
			panels[i-1].add(imagePanels[i-1], BorderLayout.CENTER);
			panels[i-1].add(buttons[i-1], BorderLayout.NORTH);
			
			mainPanel.add(panels[i-1]);
			
		}
		
		// this creates a border for the main panel
		
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(mainPanel);
			
	}

}
