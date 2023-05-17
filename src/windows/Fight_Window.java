package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import logic.Fight;
import playerClasses.Player;

public class Fight_Window extends JFrame {

	private BufferedImage icon,icon_fight;
	private JPanel p_round,p_principal,p_stats,p_stat1,p_stat2,p_stat_text1,p_stat_bar1,p_stat_bar2,p_stat_text2,p_character1,p_character2,p_characters,p_fight_icon,p_interactive,p_texts,p_i_buttons,p_center1;
	private JButton fight1,fight2;
	private String path;
	private Player player ,enemy;
	private JLabel text1,text2,text3,text4,text5,text6,text7,text8,rondas;
	private JProgressBar bar1,bar2,bar3,bar4,bar5,bar6,bar7,bar8,bar_health1,bar_health2;
	private Image_play_window p_image1,p_image2,p_image3,p_image4,p_image5,p_image6;
    private JTextArea text_print;
    private JScrollPane scrollPane;
    private Fight logic;
	
	public Fight_Window(Player player) {
		super();
		
		this.player = player;
		enemy = player.generateEnemy();
		
    	try {
			icon = ImageIO.read(new File("./src/Images/Game_icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	logic = new Fight(this.player, enemy, this);
    	
        setTitle("Races Fight");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        
        //Declaration :
        
        //Atributtes
        bar1= new JProgressBar();
        bar2= new JProgressBar();
        bar3= new JProgressBar();
        bar4= new JProgressBar();
        bar5= new JProgressBar();
        bar6= new JProgressBar();
        bar7= new JProgressBar();
        bar8= new JProgressBar();
        //health
        bar_health1= new JProgressBar();
        bar_health2= new JProgressBar();
        //panel
        p_principal = new JPanel(); // 0
        p_stats=new JPanel();		// 1
        p_stat1=new JPanel();		// 2
        p_stat2=new JPanel();		// 3
        p_stat_text1=new JPanel();	// 4
        p_stat_text2=new JPanel();	// 5
        p_stat_bar1=new JPanel();	// 6
        p_stat_bar2=new JPanel();	// 7
        p_round=new JPanel();		// 8
        p_character1=new JPanel();	// 9
        p_character2=new JPanel();	// 10
        p_fight_icon=new JPanel();	// 11
        p_interactive=new JPanel();	// 12
        p_i_buttons=new JPanel();	// 13
        p_center1= new JPanel();	// 14
        p_texts=new JPanel();		// 15
        //image character
        p_image1=new Image_play_window(this.player.getData().getWeaponImage(this.player.getWeapon().getName()), 70, 70);
        p_image2=new Image_play_window(enemy.getData().getWeaponImage(enemy.getWeapon().getName()), 70, 70);
        //image weapon
        try {
			p_image3= new Image_play_window(this.player.getData().getWarrior(this.player.getId())[2], 300, 300);
	        p_image4= new Image_play_window(enemy.getData().getWarrior(enemy.getId())[2], 300, 300);

		} catch (SQLException e) {
			e.printStackTrace();
		}
        p_image5=new Image_play_window("./src/Images/Fight_icon.jpg", 100, 100);
        //text  north
        text1= new JLabel("Power");
        text2=new JLabel("Agility");
        text3=new JLabel("Speed");
        text4=new JLabel("Defense");
        text5= new JLabel("Power");
        text6=new JLabel("Agility");
        text7=new JLabel("Speed");
        text8=new JLabel("Defense");
        rondas= new JLabel("Round 1");
        rondas.setForeground(Color.RED);
        rondas.setFont(new Font("Arial", Font.BOLD, 20)); 
        //button
        fight1= new JButton("Fight");
        fight1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				logic.fight();
				
			}
        	
        });
        fight2= new JButton("Clear Console");
        fight2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				text_print.setText("");
				
			}
        	
        });
        
        //textArea
        text_print = new JTextArea(10,50);
        scrollPane = new JScrollPane(text_print);
        
        //Asignation :
        //progressionBar
        bar1.setMinimum(0);
        bar1.setMaximum(12);
        bar1.setValue(player.getPower());
        
        bar2.setMinimum(0);
        bar2.setMaximum(12);
        bar2.setValue(player.getAgility());
           
        bar3.setMinimum(0);
        bar3.setMaximum(12);
        bar3.setValue(player.getSpeed());
        
        bar4.setMinimum(0);
        bar4.setMaximum(12);
        bar4.setValue(player.getDefense());
        
        bar5.setMinimum(0);
        bar5.setMaximum(12);
        bar5.setValue(enemy.getPower());
        
        bar6.setMinimum(0);
        bar6.setMaximum(12);
        bar6.setValue(enemy.getAgility());
       
        bar7.setMinimum(0);
        bar7.setMaximum(12);
        bar7.setValue(enemy.getSpeed());
        
        bar8.setMinimum(0);
        bar8.setMaximum(12);
        bar8.setValue(enemy.getDefense());
        //progressionBar Health
        bar_health1.setMinimum(0);
        bar_health1.setMaximum(player.getHealth());
        bar_health1.setValue(player.getHealth());
        bar_health1.setStringPainted(true);
        bar_health1.setPreferredSize(new Dimension(200,50));
        
        bar_health2.setMinimum(0);
        bar_health2.setMaximum(enemy.getHealth());
        bar_health2.setValue(enemy.getHealth());
        bar_health2.setStringPainted(true);
        bar_health2.setPreferredSize(new Dimension(200,50));
        //principal panels 
        p_principal.setLayout(new BorderLayout());        
        p_stats.setLayout(new BorderLayout());
        p_stat1.setLayout(new BoxLayout(p_stat1,  BoxLayout.X_AXIS));        
        p_stat2.setLayout(new BoxLayout(p_stat2,  BoxLayout.X_AXIS));
        p_stat_text1.setLayout(new BoxLayout(p_stat_text1, BoxLayout.Y_AXIS));
        p_stat_text2.setLayout(new BoxLayout(p_stat_text2, BoxLayout.Y_AXIS));
        p_stat_bar1.setLayout(new BoxLayout(p_stat_bar1, BoxLayout.Y_AXIS));
        p_stat_bar2.setLayout(new BoxLayout(p_stat_bar2, BoxLayout.Y_AXIS));
        p_character1.setLayout(new BoxLayout(p_character1, BoxLayout.Y_AXIS));
        p_character2.setLayout(new BoxLayout(p_character2, BoxLayout.Y_AXIS));
        p_interactive.setLayout(new BoxLayout(p_interactive, BoxLayout.Y_AXIS));
        p_i_buttons.setLayout(new BoxLayout(p_i_buttons, BoxLayout.Y_AXIS));
        p_round.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        p_fight_icon.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        p_center1.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Add panel :
        p_stat_text1.add(text1);
        p_stat_text1.add(text2);
        p_stat_text1.add(text3);
        p_stat_text1.add(text4);
        
        p_stat_text2.add(text5);
        p_stat_text2.add(text6);
        p_stat_text2.add(text7);
        p_stat_text2.add(text8);

        p_stat_bar1.add(bar1);
        p_stat_bar1.add(bar2);
        p_stat_bar1.add(bar3);
        p_stat_bar1.add(bar4);
        
        p_stat_bar2.add(bar5);
        p_stat_bar2.add(bar6);
        p_stat_bar2.add(bar7);
        p_stat_bar2.add(bar8);
        
        p_stat1.add(p_image1);
        p_stat1.add(p_stat_text1);
        p_stat1.add(p_stat_bar1);
        
        p_stat2.add(p_image2);
        p_stat2.add(p_stat_text2);
        p_stat2.add(p_stat_bar2);
        
        p_stats.add(p_stat1,BorderLayout.WEST);
        p_stats.add(p_stat2,BorderLayout.EAST);
        
        p_round.add(rondas);
        p_stats.add(p_round);
        
        p_character1.add(bar_health1);
        p_character1.add(p_image3);
       
        p_character2.add(bar_health2);
        p_character2.add(p_image4);

        p_fight_icon.add(p_image5);

        p_i_buttons.add(fight1);
        p_i_buttons.add(fight2);

        p_center1.add(p_i_buttons);

        
        p_texts.add(scrollPane,BorderLayout.CENTER);
        
        p_interactive.add(p_center1);
        p_interactive.add(p_texts);
        
        p_principal.add(p_stats,BorderLayout.NORTH);
        p_principal.add(p_character1,BorderLayout.WEST);
        p_principal.add(p_character2,BorderLayout.EAST);
        p_principal.add(p_fight_icon,BorderLayout.CENTER);
        p_principal.add(p_interactive,BorderLayout.SOUTH);
        add(p_principal,BorderLayout.NORTH);       
		
        setVisible(true);
	}
	
	public void setTextPrint(String text) {
		text_print.setText(text_print.getText() + "\n"+text);
	}
	
	public void setHp() {
		bar_health1.setValue(player.getHealth());
		bar_health2.setValue(enemy.getHealth());
	}
	
	public void setRondas(String text) {
		rondas.setText(text);
	}
}


