package mainPackage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Choose_Character_Window extends JFrame implements ActionListener{
	private BufferedImage icon;
    private JPanel[] p_character, p_race;
    private Image_character[] p_image;
    private JButton[] b_name;
    private Characters c_data;
    private Create_data_local local;
    private Datos datos = new Datos();
    public Choose_Character_Window(Create_data_local local) {
    	this.local=local;
        try {
            icon = ImageIO.read(new File("./src/Images/icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        setTitle("Races Fight");
        setSize(700, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        
        p_character = new JPanel[9];
        p_race = new JPanel[3];
        p_image = new Image_character[9];
        b_name = new JButton[9];
        
        for(int i=0; i<9; i++) {
            p_character[i] = new JPanel();
            p_character[i].setLayout(new BoxLayout(p_character[i], BoxLayout.Y_AXIS));
            b_name[i] = new JButton();
            b_name[i].setAlignmentX(JPanel.CENTER_ALIGNMENT);
        }
        
        for(int i=0; i<3; i++) {
            p_race[i] = new JPanel();
            p_race[i].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }
        
        p_image[0] = new Image_character("./src/Images/Elfo1.jpg");
        p_image[1] = new Image_character("./src/Images/Elfo2.jpg");
        p_image[2] = new Image_character("./src/Images/Elfo3.jpg");
        p_image[3] = new Image_character("./src/Images/Humano1.jpg");
        p_image[4] = new Image_character("./src/Images/Humano2.jpg");
        p_image[5] = new Image_character("./src/Images/Humano3.jpg");
        p_image[6] = new Image_character("./src/Images/Enano1.jpg");
        p_image[7] = new Image_character("./src/Images/Enano2.jpg");
        p_image[8] = new Image_character("./src/Images/Enano3.jpg");
        
        b_name[0].setText("Maedhros");
        b_name[1].setText("Miriel");
        b_name[2].setText("Fëanor");
        b_name[3].setText("Arthur");
        b_name[4].setText("Drogo");
        b_name[5].setText("Benedict");
        b_name[6].setText("Gregory");
        b_name[7].setText("Haywood");
        b_name[8].setText("Jeremiah");
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                p_character[i*3+j].add(p_image[i*3+j]);
                p_character[i*3+j].add(b_name[i*3+j]);
                p_race[i].add(p_character[i*3+j]);
            }
            p_race[i].setLayout(new BoxLayout(p_race[i], BoxLayout.X_AXIS));
        }
        
        JPanel p_principal = new JPanel(new GridLayout(3,1));
        p_principal.add(p_race[0]);
        p_principal.add(p_race[1]);
        p_principal.add(p_race[2]);
        
        add(p_principal);
        
        for (int i = 0; i < b_name.length; i++) {
            b_name[i].addActionListener(this);
        }

        
        setVisible(true);
	}
    
	public  Characters select_character_stat(String raza) {
		for (Characters c: datos.getCharactersList()) {
			if (c.getRace().equals(raza)) {
				return c;
			}
		}
		 return null;
	}
    
    
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b_name[0]) {
          
           c_data=select_character_stat("Elf");
           
        } else if (e.getSource() == b_name[1]) {
        	c_data=select_character_stat("Elf");
        }else if (e.getSource() == b_name[2]) {
        	c_data=select_character_stat("Elf");
        }else if (e.getSource() == b_name[3]) {
        	c_data=select_character_stat("Humà");
        }else if (e.getSource() == b_name[4]) {
        	c_data=select_character_stat("Humà");
        }else if (e.getSource() == b_name[5]) {
        	c_data=select_character_stat("Humà");
        }else if (e.getSource() == b_name[6]) {
        	c_data=select_character_stat("Nan");
        }else if (e.getSource() == b_name[7]) {
        	c_data=select_character_stat("Nan");
        }else if (e.getSource() == b_name[8]) {
        	c_data=select_character_stat("Nan");
        }
		dispose();
		local.setJugador(c_data);
		new Starting_Window(local);
		System.out.println(local.toString());
		
	}

	public Characters getC_data() {
		return c_data;
	}

	public void setC_data(Characters c_data) {
		this.c_data = c_data;
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