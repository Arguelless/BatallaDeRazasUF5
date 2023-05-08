package mainPackage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

//
    public class Choose_Weapon_Window extends JFrame implements ActionListener {
        private BufferedImage icon;
        private JPanel p_principal, p_elf, p_hum, p_enan;
        private JPanel[] panels = new JPanel[9];
        private Image_character[] images = new Image_character[9];
        private JButton[] b_name = new JButton[9];
        private Weapons w_data;
        //private String path;
        private Create_data_local local;
        private Datos dato=new Datos();
        private ArrayList<Weapons> available_weapons=new ArrayList<Weapons>(); ;
        
        public Choose_Weapon_Window(Create_data_local local) {
        	this.local=local;
            try {
                icon = ImageIO.read(new File("./src/Images/icon.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Panels_needed(local);
            setTitle("Races Fight");
            setSize(700, 800);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(icon);

            p_principal = new JPanel();
            
            p_elf = new JPanel();
            p_enan = new JPanel();
            p_hum = new JPanel();
			
            p_principal.setLayout(new GridLayout(3, 1));
            
            p_elf.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            p_enan.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            p_hum.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			
            
            for (int i = 0; i < available_weapons.size(); i++) {
                panels[i] = new JPanel();
                panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.Y_AXIS));
                images[i] = new Image_character("./src/Images/" + getImageFilename(available_weapons.get(i)));
                b_name[i] = new JButton(available_weapons.get(i).getWeapon());
                b_name[i].setAlignmentX(JPanel.CENTER_ALIGNMENT);
                panels[i].add(images[i]);
                panels[i].add(b_name[i]);
                //p_principal.add(panels[i]);
            }
            
            for (int i = 0; i < 3; i++) {
            	try {
            		p_elf.add(panels[i]);
                    p_enan.add(panels[i + 3]);
                    p_hum.add(panels[i + 6]);
				} catch (Exception e) {

				}
                
            }
			
            
            p_principal.add(p_elf);
            p_principal.add(p_enan);
            p_principal.add(p_hum);
			
            add(p_principal);
            
            for (int i = 0; i < available_weapons.size(); i++) {
                b_name[i].addActionListener(this);
            }
            
            setVisible(true);
        }
        
        public void Panels_needed(Create_data_local local) {
        	
        	for (Weapons w : dato.getWeaponsList()) {
        		if (w.getRace_use().contains(local.getJugador().getRace())) {
        			available_weapons.add(w);
        		}
        	}
        	
        }
        
        private String getImageFilename(Weapons i) {
        	 File folder = new File("./src/Images/");
             

             File[] files = folder.listFiles();
            
        	 for (File file : files) {
        		 //System.out.println(file.getName());
        		 //System.out.println(i.getWeapon());
                 if(file.getName().substring(0, file.getName().lastIndexOf('.')).equals(i.getWeapon())) {
                	 return file.getName();
                 }
             }
        	 
             
			return null;
        
        }


	public void actionPerformed(ActionEvent e) {
		Datos dato=new Datos();
	
		for (JButton b : b_name) {
			if (e.getSource() == b) {

				
		        for (Weapons w :dato.getWeaponsList()) {
		        	if (w.getWeapon().equals(b.getText())) {
		        		w_data=w;
		        	}
		        }
		        } 
		}

		
		dispose();
		local.setJugador_w(w_data);;
		new Starting_Window(local);
		System.out.println(local.toString());
		
	}

	public Weapons getW_data() {
		return w_data;
	}

	public void setW_data(Weapons w_data) {
		this.w_data = w_data;
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