package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Starting_Window extends JFrame implements ActionListener{
	private boolean character_choosed=false;
	private JLabel error_messages;
	private BufferedImage icon;
	private JPanel p_principal,p1,p2,p3,panel_image;
	private JButton play,c_character,c_weapon,ranking,exit;
	private Choose_Character_Window Choose_character;
    public Starting_Window() {
    	
    	try {
			icon = ImageIO.read(new File("./src/Images/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
        setTitle("Races Fight");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        
        error_messages=new JLabel("");
        error_messages.setForeground(Color.RED);
        error_messages.setFont(new Font("Arial", Font.BOLD, 20)); 
        
        p_principal=new JPanel();
        p_principal.setLayout(new BoxLayout(p_principal,BoxLayout.Y_AXIS));
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		p_principal.add(p1);
		p_principal.add(p2);
		p_principal.add(p3);
		add(p_principal);
    	
		panel_image = new Image();
		p1.add(panel_image);
		
		play=new JButton("Play");
		c_character=new JButton("Choose a Character");
		c_weapon=new JButton("Choose a Weapon");
		exit=new JButton("Exit");
		ranking=new JButton("Ranking");
		
		p2.add(play);
		p2.add(c_character);
		p2.add(c_weapon);
		p2.add(exit);
        p2.add(ranking);
		
		p3.add(error_messages);
        

		play.addActionListener(this);
		c_character.addActionListener(this);
		c_weapon.addActionListener(this);
		exit.addActionListener(this);
		
		
		
        setVisible(true);
    }
    
    public Characters return_data() {
    	return Choose_character.getC_data();
    }
    
    
public Choose_Character_Window getChoose_character() {
		return Choose_character;
	}

	public void setChoose_character(Choose_Character_Window choose_character) {
		Choose_character = choose_character;
	}

public void actionPerformed(ActionEvent evento) {
    	
        try {
        	
        	
            if (evento.getSource() == play) {
                if(character_choosed==false) {
                	throw new Starting_windows_exception("Error: You can't play without any characters selected");
                } else {
                	error_messages.setVisible(false);
                }
            } else if (evento.getSource() == c_character) {
            	
            	error_messages.setVisible(false);
            	Choose_character =new Choose_Character_Window();
            } else if (evento.getSource() == c_weapon) {
            	if(character_choosed==false) {
                	throw new Starting_windows_exception("Error: You can't choose a weapon without any characters selected");
                } else {
                	error_messages.setVisible(false);
                }
            } else if (evento.getSource() == ranking) {
            	error_messages.setText("Queda para hacer");
            	character_choosed=true;
            	//error_messages.setVisible(false);
            }else if (evento.getSource() == exit) {
            	dispose();
            }
            setVisible(false);
        } catch (Starting_windows_exception e) {
        	error_messages.setText(e.getMessage());
        	error_messages.setVisible(true);
        } 
    }

    
}


class Image extends JPanel{
	private BufferedImage image1;
	public Image() {
		try {
			image1 = ImageIO.read(new File("./src/Images/Starting_Menu_image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(733,476));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image1,0,0,null);
	}
}
