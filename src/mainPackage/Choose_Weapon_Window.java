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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

//	Aun no lo se porque el programa me va bien pero el archivo me sale una cruz
    public class Choose_Weapon_Window extends JFrame implements ActionListener {
        private BufferedImage icon;
        private JPanel p_principal, p_elf, p_hum, p_enan;
        private JPanel[] panels = new JPanel[9];
        private Image_character[] images = new Image_character[9];
        private JButton[] b_name = new JButton[9];
        private Weapons w_data;
        private Database d = new Database();
        private Create_data_local local;
        private ArrayList<Weapons> available_weapons=new ArrayList<Weapons>(); ;
        
        public Choose_Weapon_Window(Create_data_local local) {
        	//Esto sirve para guardar los cambios mientras el usuario elege personajes o armas
        	this.local=local;
        	//
        	
        	//Cargar el icono del app
            try {
                icon = ImageIO.read(new File("./src/Images/Game_icon.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //
            
            /*En weapons es un poco diferente la logica, lo que he hecho
            * es si eliges elf de character, solo te saldra armas para elf
            * no se instanciaran las armas que no son compatibles con 
            * tu raza
            */
            
            //Metodo que coge el dato guardado, te mira que raza eres, y te modifica el arraylist
            //"available_weapons" con weapons tuyas, asi sabiendo cuantos paneles necesita para
            //mostrar las armas 
            Weapon_use(local);
            //
            
            //Al ciclo de automocion que es mas facil tambien
            setTitle("Races Fight");
            setSize(700, 800);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(icon);
            //
            
            // declarar los paneles, ignorate lo de p_elf, p_enan... es unos de los restos copy paste del choose character 
            p_principal = new JPanel();
            
            p_elf = new JPanel();
            p_enan = new JPanel();
            p_hum = new JPanel();
			
            p_principal.setLayout(new GridLayout(3, 1));
            
            p_elf.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            p_enan.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            p_hum.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			//
            
            //Este for segun arraylist "available_weapons" crea paneles necesarios, y conseguir imagenes, botones, 
            //y meterlos en esos paneles necesarios
            int ID_weapon=0;
            for (int i = 0; i < available_weapons.size(); i++) {
                panels[i] = new JPanel();
                panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.Y_AXIS));
                b_name[i] = new JButton(available_weapons.get(i).getWeapon());
                b_name[i].setAlignmentX(JPanel.CENTER_ALIGNMENT);
                
                try {
					ID_weapon=d.getWeaponStats(b_name[i].getText())[2];
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                images[i] = new Image_character(getImageFilename1(ID_weapon));
                
                
                panels[i].add(images[i]);
                panels[i].add(b_name[i]);
            }
            //
            
            // Añadir cada pequeña pieza de panel en cada panel fila
            //uso un try catch porque siempre habra unos paneles sin declarar que me hace petar,
            //Con esto ignoro esos errores, y metera armas que si hacen falta
            for (int i = 0; i < 3; i++) {
            	try {
            		p_elf.add(panels[i]);
                    p_enan.add(panels[i + 3]);
                    p_hum.add(panels[i + 6]);
				} catch (Exception e) {
					
				}
                
            }
			//
            
            
            // Ufff ya me estoy cansando de documentar
            p_principal.add(p_elf);
            p_principal.add(p_enan);
            p_principal.add(p_hum);
			
            add(p_principal);
            //
            
            //Una manera lista de capturar los clicks de botones
            for (int i = 0; i < available_weapons.size(); i++) {
                b_name[i].addActionListener(this);
            }
            //
            
            //Trabajar en el insti como señora de limpieza tambien se cobra 1200 al mes, eso me lo han dicho un profe del año pasado
            setVisible(true);
            //
        }
        
        //Metodo que segun tu raza te mete los weapons tuyos en un arraylist declarado en la clase
        
        public void Weapon_use(Create_data_local local) {
        	int[] weapons_ids = new int[0];
        	try {
        		weapons_ids=d.getAvailableWeapons(d.getWarriorID(local.getJugador_c_name().getName()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	Object[] weapons_data=new Object[0];
        	for (int i = 0; i < weapons_ids.length; i++) {
        		//Weapons(String weapon, ArrayList<Integer> description, ArrayList<String> race_use) {
        		try {
        			
        			weapons_data=d.getWeaponAllStatNoID(weapons_ids[i]);
        			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		int speed =  (int) weapons_data[3];
        		int power = (int) weapons_data[2];
        		
        		w_data= new Weapons(weapons_data[0]+"", new ArrayList<Integer>(Arrays.asList(speed,power)));
        		available_weapons.add(w_data);
        	}
        	
        }
        
        //
        
        //Metodo que compara el nombre del weapon de la clase con el de archivo en la carpeta "Images"
        //Asi conseguir la ruta para dibujar imagen 
        
        //
        private String getImageFilename1(int id) {
        	Database d =new Database();
        	String file_path="";
        	try {
        		file_path =d.getWeaponAllStatNoID(id)[1]+"";
			} catch (Exception e) {
				// TODO: handle exception
			}
       	 	
       	   
			return file_path;
       
       }
        
        
        
        
    //Lo decia en archivo choose character, esta es la manera lista de guardar los stats del weapon que 
    //elegistes en "local", lo que hace es conseguir el nombre del boton que pulsastes, comparando con los nombres de weapons 
    //datos guardados.
    //Si coinciden te guarda en "local"
	public void actionPerformed(ActionEvent e) {

		for (JButton b : b_name) {
			if (e.getSource() == b) {
		        for (Weapons w :available_weapons) {
		        	if (w.getWeapon().equals(b.getText())) {
		        		w_data=w;
		        	}
		        }
		        } 
		}

		
		dispose();
		local.setJugador_w(w_data);;
		//Volver al menu principal con el dato de la partida siempre guardado
		new Starting_Window(local);
		//
		//System.out.println(local.toString());
		
	}

	
	
}

//Hay la misma clase en choose character
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
//