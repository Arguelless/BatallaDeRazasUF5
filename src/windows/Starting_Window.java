package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import playerClasses.Player;

public class Starting_Window extends JFrame implements ActionListener{
	private Player player;
	private JLabel error_message;
	private BufferedImage icon, image;
	private JPanel panels[];
	private JButton buttons[];
	
	// constructor used before character selection
	
	public Starting_Window() {
		super();
		
		player = new Player();
		
		loadIcon();
		frameParameters();
		setupPanels();
		
		setVisible(true);
		
	}
	
	// constructor used after character selection	
	
	public Starting_Window(Player player) {
		super();
		
		this.player = player;
		
		loadIcon();
		frameParameters();
		setupPanels();
		
		setVisible(true);
		
	}
	
	// method that loads the icon image
	
	public void loadIcon() {
		try {
			icon = ImageIO.read(new File("./src/Images/Game_icon.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	// this method defines the frame properties
	
	public void frameParameters() {
		setTitle("Races Fight");
		setSize(1000, 800);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        
	}
	
	// method used to setup the error_message variable
	
	public void setupErrorMessage() {
		error_message=new JLabel("");
        error_message.setForeground(Color.RED);
        error_message.setFont(new Font("Arial", Font.BOLD, 20));
        
        panels[3].add(error_message);
        
	}
	
	// method that defines each panel of the panels array
	
	public void setupPanels() {
		JPanel panel;
		panels = new JPanel[] {
			new JPanel(),		// main panel
			new JPanel(),		// p1
			new JPanel(),		// p2
			new JPanel(),		// p3
			new JPanel() {		// image panel
				 {
			        try {
			            image = ImageIO.read(new File("./src/Images/Starting_Menu_image.png"));
			            
			        } catch (IOException e) {
			            e.printStackTrace();
			            
			        }
					setPreferredSize(new Dimension(733,476));

				 }
				 public void paintComponent(Graphics g) {
				        super.paintComponent(g);
				        if (image != null) {
				            g.drawImage(image, 0, 0, this);
				        }
				 }
				
			}		
		};
		
		// set each panel layout
		
		panels[0].setLayout(new BoxLayout(panels[0],BoxLayout.Y_AXIS));
		panels[1].setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		panels[2].setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		panels[3].setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		
		// add the non main panels their components
		
		panels[1].add(panels[4]);
		setupButtons();
		setupErrorMessage();
		
		// add the other panels to the main panel
		
		panels[0].add(panels[1]);
		panels[0].add(panels[2]);
		panels[0].add(panels[3]);
		
		// add the main panel to the frame
		
		add(panels[0]);
	}
	
	// method to initialize the button array
	
	public void setupButtons() {
		buttons = new JButton[] {
			new JButton("play"),
			new JButton("Choose a character"),
			new JButton("Choose a weapon"),
			new JButton("Exit"),
			new JButton("Ranking")
		};
		
		// add the buttons to their panel
		
		for(int i=0;i<buttons.length;i++) {
			buttons[i].addActionListener(this);
			panels[2].add(buttons[i]);
		}
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == buttons[0]) {
				
				if(player.getHealth()==0||player.getWeapon()==null) {
					throw new CustomException("You must choose a warrior and a weapon");
					
				}else {
					new Fight_Window(player);
					
					dispose();
					
				}
				
			}else if(e.getSource() == buttons[1]) {
				new Choose_Character_Window(player);
				
				dispose();
				
			}else if(e.getSource() == buttons[2]) {
				if(player.getHealth()==0) {
					throw new CustomException("You must choose a warrior first");
					
				}else {
					new Choose_Weapon_Window(player);
					
					dispose();
				}
				
			}else if(e.getSource() == buttons[3]) {
				this.dispose();
				
			}else if(e.getSource() == buttons[4]) {
				new Ranking();
				this.dispose();
				
			}
		} catch (CustomException c) {
			error_message.setText(c.getMessage());
        	error_message.setVisible(true);
        	
		} 
	}

}
