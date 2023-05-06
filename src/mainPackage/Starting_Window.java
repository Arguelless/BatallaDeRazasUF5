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
	private BufferedImage image1,icon;
	private JPanel p_principal,p1,p2,panel_image;
	private JButton play,ranking,exit;
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
        
        p_principal=new JPanel();
        p_principal.setLayout(new BoxLayout(p_principal,BoxLayout.Y_AXIS));
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_principal.add(p1);
		p_principal.add(p2);
		add(p_principal);
    	
		panel_image = new Image();
		p1.add(panel_image);
		
		play=new JButton("Play");
		ranking=new JButton("Ranking");
		exit=new JButton("Exit");
		
		p2.add(play);
		p2.add(ranking);
		p2.add(exit);
		
        
        
        
        

        setVisible(true);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

    
}


class Image extends JPanel{
	BufferedImage image1;
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
