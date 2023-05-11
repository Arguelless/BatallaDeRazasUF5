package mainPackage;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

//Esto lo estoy haciendo y me encontre problemas quizas en martes me ayudais
public class Play_window extends JFrame {

	private BufferedImage icon,icon_fight;
	private JPanel p_ronda,p_principal,p_stats,p_stat1,p_stat2,p_stat_text1,p_stat_bar1,p_stat_bar2,p_stat_text2,p_character1,p_character2,p_characters,p_fight_icon,p_interactive,p_texts,p_i_buttons,p_center1;
	private JButton fight1,fight2,fight3;
	private String path;
	private Create_data_local local;
	private JLabel text1,text2,text3,text4,text5,text6,text7,text8,rondas;
	private JProgressBar bar1,bar2,bar3,bar4,bar5,bar6,bar7,bar8,bar_vida1,bar_vida2;
	private Image_play_window p_image1,p_image2,p_image3,p_image4,p_image5,p_image6;
    private JTextArea text_print;
    private JScrollPane scrollPane;
	
	public Play_window(Create_data_local local) {
		this.local=local;

    	try {
			icon = ImageIO.read(new File("./src/Images/icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

        setTitle("Races Fight");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(icon);
        
        //Declaracion :
        
        //Atributos
        bar1= new JProgressBar();
        bar2= new JProgressBar();
        bar3= new JProgressBar();
        bar4= new JProgressBar();
        bar5= new JProgressBar();
        bar6= new JProgressBar();
        bar7= new JProgressBar();
        bar8= new JProgressBar();
        //vida
        bar_vida1= new JProgressBar();
        bar_vida2= new JProgressBar();
        //panel
        p_principal = new JPanel();
        p_stats=new JPanel();
        p_stat1=new JPanel();
        p_stat2=new JPanel();
        p_stat_text1=new JPanel();
        p_stat_text2=new JPanel();
        p_stat_bar1=new JPanel();
        p_stat_bar2=new JPanel();
        p_ronda=new JPanel();
        p_character1=new JPanel();
        p_character2=new JPanel();
        p_fight_icon=new JPanel();
        p_interactive=new JPanel();
        p_i_buttons=new JPanel();
        p_center1= new JPanel();
        p_texts=new JPanel();
        //imagen personaje
        p_image1=new Image_play_window("./src/Images/Arc.jpg", 70, 70);
        p_image2=new Image_play_window("./src/Images/Daga.jpg", 70, 70);
        //imagen arma
        p_image3= new Image_play_window("./src/Images/elfo1.jpg", 300, 300);
        p_image4= new Image_play_window("./src/Images/enano1.jpg", 300, 300);
        //imagen fight
        p_image5=new Image_play_window("./src/Images/fight_icon.jpg", 100, 100);
        //texto de arriba
        text1= new JLabel("Power");
        text2=new JLabel("Agility");
        text3=new JLabel("Speed");
        text4=new JLabel("Defense");
        text5= new JLabel("Power");
        text6=new JLabel("Agility");
        text7=new JLabel("Speed");
        text8=new JLabel("Defense");
        rondas= new JLabel("Ronda 1");
        rondas.setForeground(Color.RED);
        rondas.setFont(new Font("Arial", Font.BOLD, 20)); 
        //botones
        fight1= new JButton("Fight ");
        fight2= new JButton("Fight1");
        fight3= new JButton("Fight2");
        //textArea
        text_print = new JTextArea(10,200);
        scrollPane = new JScrollPane(text_print);
        
        //Asignacion :
        //barra progresion_atributo
        bar1.setMinimum(0);
        bar1.setMaximum(100);
        bar1.setValue(10);
        
        bar2.setMinimum(0);
        bar2.setMaximum(100);
        bar2.setValue(30);
           
        bar3.setMinimum(0);
        bar3.setMaximum(100);
        bar3.setValue(54);
        
        bar4.setMinimum(0);
        bar4.setMaximum(100);
        bar4.setValue(92);
        
        bar5.setMinimum(0);
        bar5.setMaximum(100);
        bar5.setValue(10);
        
        bar6.setMinimum(0);
        bar6.setMaximum(100);
        bar6.setValue(30);
       
        bar7.setMinimum(0);
        bar7.setMaximum(100);
        bar7.setValue(54);
        
        bar8.setMinimum(0);
        bar8.setMaximum(100);
        bar8.setValue(92);
        //barra progresion_Vida
        bar_vida1.setMinimum(0);
        bar_vida1.setMaximum(100);
        bar_vida1.setValue(100);
        bar_vida1.setStringPainted(true);
        bar_vida1.setPreferredSize(new Dimension(200,50));
        
        bar_vida2.setMinimum(0);
        bar_vida2.setMaximum(100);
        bar_vida2.setValue(100);
        bar_vida2.setStringPainted(true);
        bar_vida2.setPreferredSize(new Dimension(200,50));      
        //paneles principales
        p_principal.setLayout(new BorderLayout());        
        p_stats.setLayout(new BorderLayout());
        p_stat1.setLayout(new BoxLayout(p_stat1,  BoxLayout.X_AXIS));        
        p_stat2.setLayout(new BoxLayout(p_stat2,  BoxLayout.X_AXIS));
        p_stat_text1.setLayout(new BoxLayout(p_stat_text1, BoxLayout.Y_AXIS));
        p_stat_text2.setLayout(new BoxLayout(p_stat_text2, BoxLayout.Y_AXIS));
        p_stat_bar1.setLayout(new BoxLayout(p_stat_bar1, BoxLayout.Y_AXIS));
        p_stat_bar2.setLayout(new BoxLayout(p_stat_bar2, BoxLayout.Y_AXIS));
        p_ronda.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        p_character1.setLayout(new BoxLayout(p_character1, BoxLayout.Y_AXIS));
        p_character2.setLayout(new BoxLayout(p_character2, BoxLayout.Y_AXIS));
        p_fight_icon.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        p_interactive.setLayout(new BoxLayout(p_interactive, BoxLayout.Y_AXIS));
        p_i_buttons.setLayout(new BoxLayout(p_i_buttons, BoxLayout.Y_AXIS));
        p_center1.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Añadir panel :
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
        
        p_ronda.add(rondas);
        p_stats.add(p_ronda);
        
        p_character1.add(bar_vida1);
        p_character1.add(p_image3);
       
        p_character2.add(bar_vida2);
        p_character2.add(p_image4);

        p_fight_icon.add(p_image5);

        p_i_buttons.add(fight1);
        p_i_buttons.add(fight2);
        p_i_buttons.add(fight3);

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
}


class Image_play_window extends JPanel {
    private BufferedImage image;
    private int scaledWidth;
    private int scaledHeight;

    public Image_play_window(String path, int x, int y) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // calcular la escala para ajustar la imagen al tamaño de la ventana
        double scaleX = (double) x / image.getWidth();
        double scaleY = (double) y / image.getHeight();
        double scale = Math.min(scaleX, scaleY);

        // escalar la imagen
        scaledWidth = (int) (scale * image.getWidth());
        scaledHeight = (int) (scale * image.getHeight());
        Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        image = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        setPreferredSize(new Dimension(scaledWidth, scaledHeight));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
    }
}
/*
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
*/
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
