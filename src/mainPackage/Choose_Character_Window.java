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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private Database d = new Database();
    
    public Choose_Character_Window(Create_data_local local) {
    	//Esto sirve para guardar los cambios mientras el usuario elege personajes o armas
    	this.local=local;
    	//
    	
    	//Cargar el icono del app
        try {
            icon = ImageIO.read(new File("./src/Images/icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        
        //Vete al ciclo de Administracion si no entiendes esto
        setTitle("Races Fight");
        setSize(700, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        //
        
        //Declarar LOS arrays del JPanel, el array del clase que sera los imagenes de los characters que tengo, el array de JButton
        p_character = new JPanel[9];
        p_race = new JPanel[3];
        p_image = new Image_character[9];
        b_name = new JButton[9];
        //
        
        //Como sabeis tengo 9 paneles que cada panel tiene un imagen y un boton
        //Aqui se trata de crear esos 9 paneles y 9 botones, y decir al boton que queda centrado
        for(int i=0; i<9; i++) {
            p_character[i] = new JPanel();
            p_character[i].setLayout(new BoxLayout(p_character[i], BoxLayout.Y_AXIS));
            b_name[i] = new JButton();
            b_name[i].setAlignmentX(JPanel.CENTER_ALIGNMENT);
        }
        //
        
        //Esos 9 paneles los separo con 3 más, que daran un formato de panel primera fila con p_character[0-2],
        // panel segunda fila con p_character[3-5]
        // panel tercera fila con p_character[6-8]
        for(int i=0; i<3; i++) {
            p_race[i] = new JPanel();
            p_race[i].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }
        //
        
        //Esto seguramente hay que cambiarlo, pero igualmente y dejo asi porque me da palo ya,
        //Se trata de instanciar la clase que esta abajo del archivo que se llama Image_character,
        //Dandole una ruta para que pueda pintar el imagen en estos arrays de clase Image_character,
        //Y cada p_image[n] es un imagen que le metere en un panel luego.
        
        for (int i = 0; i < p_image.length; i++) {
        	
        	try {
				p_image[i]=new Image_character(d.getWarrior(i)[3]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	/*
            p_image[0] = new Image_character("./src/Images/Elfo1.jpg");
            p_image[1] = new Image_character("./src/Images/Elfo2.jpg");
            p_image[2] = new Image_character("./src/Images/Elfo3.jpg");
            p_image[3] = new Image_character("./src/Images/Humano1.jpg");
            p_image[4] = new Image_character("./src/Images/Humano2.jpg");
            p_image[5] = new Image_character("./src/Images/Humano3.jpg");
            p_image[6] = new Image_character("./src/Images/Enano1.jpg");
            p_image[7] = new Image_character("./src/Images/Enano2.jpg");
            p_image[8] = new Image_character("./src/Images/Enano3.jpg");
            */
        }
        
        //
        
        //Lo mismo, hay que cambiarlo, esto es poner los nombres de botones al nombre del character que toca.
        //Hay que cambiarlo en forma que utilice los nombres guardados en la clase Datos.
        b_name[0].setText("Maedhros");
        b_name[1].setText("Miriel");
        b_name[2].setText("Feanor");
        b_name[3].setText("Arthur");
        b_name[4].setText("Drogo");
        b_name[5].setText("Benedict");
        b_name[6].setText("Gregory");
        b_name[7].setText("Haywood");
        b_name[8].setText("Jeremiah");
        //
        
        //Esta complicada la logica interior de estos doble fors, te digo directamente lo que hace
        //Aqui mete los botones y imagen en cada p_character, despues de tres en tres meter p_character en p_race
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                p_character[i*3+j].add(p_image[i*3+j]);
                p_character[i*3+j].add(b_name[i*3+j]);
                p_race[i].add(p_character[i*3+j]);
            }
            p_race[i].setLayout(new BoxLayout(p_race[i], BoxLayout.X_AXIS));
        }
        //
        
        //Un gridlayout de panel principal donde meto los tres filas y añadirlos en el JFrame
        JPanel p_principal = new JPanel(new GridLayout(3,1));
        p_principal.add(p_race[0]);
        p_principal.add(p_race[1]);
        p_principal.add(p_race[2]);        
        add(p_principal);
        //
        
        //Esto para el capturar los clicks de cada boton simplemente
        for (int i = 0; i < b_name.length; i++) {
            b_name[i].addActionListener(this);
        }
        //
        
        //No entiendes ??
        setVisible(true);
        //
	}
    
    
    //Esto es un metodo, para que sepas estas fuera del constructor ya
    //Lo que hace es Devolver el stats de elfo, humano, enano segun la raza que elige el usuario
	public  Characters select_character_stat(String raza) {
		for (Characters c: datos.getCharactersList()) {
			if (c.getRace().equals(raza)) {
				return c;
			}
		}
		 return null;
	}
	//
    
    //Esto es para los acciones que hacen los botones
	public void actionPerformed(ActionEvent e) {
		//Estos ifs se pueden mejorar como el formato mas o menos en el Choose weapon.
		//Lo que hacen es llamar el metodo select_character_stat dandole el String raza
		//y que return el stat de cada raza diferente.
		
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
		//
		
		//Cerrar la ventana, guardar los datos modificados, volver la ventana principal
		dispose();
		local.setJugador(c_data);
		new Starting_Window(local);
		//System.out.println(local.toString());
		//
		
	}
	
}

// Que palo ya de comentar, la clase esta funciona como un metodo externo, coge un imagen segun la ruta dandole un tamaño 220x220
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
		// Pa que preguntes, este translate dibuja desde el punto adecuado del imagen para la ventana, entenderas mejor si la quitas y ejecutalo
        g2d.translate(-40, -40); 
        //
		g2d.drawImage(image1,0,0,null);
		g2d.dispose();
	}
}
//