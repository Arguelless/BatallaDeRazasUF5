package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

//Creo que es la ventana mas facil del proyecto
public class Starting_Window extends JFrame implements ActionListener{
	private boolean character_choosed=false;
	private JLabel error_messages;
	private BufferedImage icon;
	private JPanel p_principal,p1,p2,p3,panel_image;
	private JButton play,c_character,c_weapon,ranking,exit;
	private Create_data_local local;
    public Starting_Window(Create_data_local local) {
    	//Esto sirve para guardar los cambios mientras el usuario elege personajes o armas
    	this.local=local;
    	//
    	
    	//Para comprobar si el usuario ya elegio un character
    	if (local.getJugador()!=null) {
    		character_choosed=true;
    	}
    	//
    	
    	//Cargar el icono del app
    	try {
			icon = ImageIO.read(new File("./src/Images/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//
    	
    	//No me acuerdo mas historias que contar
        setTitle("Races Fight");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        //
        
        //Mensaje de Excepciones que sale si haces mal algo
        error_messages=new JLabel("");
        error_messages.setForeground(Color.RED);
        error_messages.setFont(new Font("Arial", Font.BOLD, 20)); 
        //
        
        //Crear paneles
        p_principal=new JPanel();
        p_principal.setLayout(new BoxLayout(p_principal,BoxLayout.Y_AXIS));
		p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
		//
		
		//Añadirlos en el panel principal y al frame
		p_principal.add(p1);
		p_principal.add(p2);
		p_principal.add(p3);
		add(p_principal);
    	//
		
		//Esto es para la foto tope de fea del inicio
		panel_image = new Image();
		p1.add(panel_image);
		//
		
		//Los 4 botones 
		play=new JButton("Play");
		c_character=new JButton("Choose a Character");
		c_weapon=new JButton("Choose a Weapon");
		exit=new JButton("Exit");
		ranking=new JButton("Ranking");
		//
		
		//Añadirlos al panel fila2 
		p2.add(play);
		p2.add(c_character);
		p2.add(c_weapon);
		p2.add(exit);
        p2.add(ranking);
		//
        
        //Panel fila 3 para la excepcion
		p3.add(error_messages);
        //

		//Capturar los clicks de los botones
		play.addActionListener(this);
		c_character.addActionListener(this);
		c_weapon.addActionListener(this);
		ranking.addActionListener(this);
		exit.addActionListener(this);
		//
		
		//....
        setVisible(true);
        //
    }
    
   
// Lo mismo que he hecho en el examen de UF5 
public void actionPerformed(ActionEvent evento) {
    	
		//Te intenta ejecutar los botones, pero si no cumples los requistos para cada boton te sale el mensaje que lo indica
        try {
        	
            if (evento.getSource() == play) {
            	
                if(character_choosed==false) {
                	throw new Starting_windows_exception("Error: You can't play without any characters selected");
                } else {
                	
                	error_messages.setVisible(false);
                	dispose();
                	new Play_window(local);
                }
            } else if (evento.getSource() == c_character) {
            	
            	error_messages.setVisible(false);
            	new Choose_Character_Window(local);
            	//System.out.println(local.toString());
            	dispose();
            	
            } else if (evento.getSource() == c_weapon) {
            	if(character_choosed==false) {
                	throw new Starting_windows_exception("Error: You can't choose a weapon without any characters selected");
                } else {
                	
                	error_messages.setVisible(false);
                	dispose();
                	//System.out.println(local.toString());
                	new Choose_Weapon_Window(local);
                	//System.out.println(local.toString());
                }
            } else if (evento.getSource() == ranking) {
            	throw new Starting_windows_exception("Error: Queda para hacer");
            	//error_messages.setVisible(false);
            }else if (evento.getSource() == exit) {
            	dispose();
            }
            
        } catch (Starting_windows_exception e) {
        	error_messages.setText(e.getMessage());
        	error_messages.setVisible(true);
        } 
    }

    //
}
//

//Clase que funciona como metodo para dibujar una imagen
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
//
