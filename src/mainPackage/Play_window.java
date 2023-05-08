package mainPackage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

//Esto lo estoy haciendo y me encontre problemas quizas en martes me ayudais
public class Play_window extends JFrame {

	private BufferedImage icon,icon_fight;
	private JPanel p_principal,p_stats,p_stat1,p_stat2,p_stat3,p3,panel_image1,panel_image2,panel_image3,panel_image4,panel_image5;
	private JButton proba1,proba2,proba3;
	private String path;
	private Create_data_local local;
	
	public Play_window(Create_data_local local) {
		this.local=local;

    	try {
			icon = ImageIO.read(new File("./src/Images/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	try {
			icon_fight = ImageIO.read(new File("./src/Images/fight_icon.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        setTitle("Races Fight");
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        
        p_principal = new JPanel();
        p_stats=new JPanel();
        p_stat1=new JPanel();
        p_stat2=new JPanel();
        p_stat3=new JPanel();
        
        proba1=new JButton("Stat1");
        proba2=new JButton("Stat2");
        proba3=new JButton("Stat3");
        
        p_stat1.add(proba1);
        p_stat2.add(proba2);
        p_stat3.add(proba3);
        p_stats.add( p_stat1,BorderLayout.WEST);
        p_stats.add( p_stat2,BorderLayout.EAST);
        p_stats.add( p_stat3,BorderLayout.CENTER);
        p_principal.add(p_stats,BorderLayout.NORTH);
        
        add(p_principal);
        
		
        setVisible(true);
		
		
		
	}
	
	
	
	
	
	
	
	
}



class Image_character extends JPanel{
	private BufferedImage image1;
	public Image_character(String path) {
		try {
			image1 = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(220,220));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
        g2d.translate(-40, -40); 
		g2d.drawImage(image1,0,0,null);
		g2d.dispose();
	}
}

class Bar extends JPanel {
	private float value = 0;
    private Color color;
    public Bar(float vida_total,float vida_actual) {
        setPreferredSize(new Dimension(200, 20));
        value=(100/vida_total)*vida_actual;

    	
        if (value <= 30) {
        	color = Color.RED;
        } else if (value > 30 && value < 70) {
        	color = Color.YELLOW;
        } else {
        	color = Color.GREEN;
        }
        repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        float width = getWidth();

        float barWidth = (width/100)*value;

        g.setColor(color);
        g.fillRect(0, 0,  (int) Math.round(barWidth), 100);


    }
}

class Set_bot_character{
	private Random rand = new Random();
    private int index_random ;
    private Create_data_local local ;
    private Datos datos = new Datos();
    
    
    public Set_bot_character(Create_data_local local) {
    	this.local=local;
    	// primero personaje
    	index_random= rand.nextInt(datos.getCharactersList().size());
    	local.setBot(datos.getCharactersList().get(index_random));
    	
    	boolean salir=false;
    	while (salir==false) {
    		index_random= rand.nextInt(datos.getNameList().size());
    		if (datos.getNameList().get(index_random).getRace().equals(local.getBot().getRace())){
    			salir=true;
    			local.setBot_c_name(datos.getNameList().get(index_random));
    		}
    		
    	}
    	//Ahora arma
    	salir=false;
    	while (salir==false) {
    		index_random= rand.nextInt(datos.getWeaponsList().size());
    		if (datos.getWeaponsList().get(index_random).getRace_use().contains(local.getBot().getRace())){
    			salir=true;
    			local.setBot_w(datos.getWeaponsList().get(index_random));
    		}
    		
    	}

	}

    
}
//
