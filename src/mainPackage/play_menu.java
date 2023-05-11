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

public class play_menu extends JFrame {
    private JPanel stats, stat1, stat2, statText1, statText2, statBar1, statBar2;
    private JLabel text1, text2, text3, text4, text5, text6, text7, text8, rondas;
    private JProgressBar[] bars = new JProgressBar[8], vidaBars = new JProgressBar[2];
    private Image_play_window[] images = new Image_play_window[6];
    private JTextArea textPrint;
    private JScrollPane scrollPane;

    public play_menu(Create_data_local local) {
        try {
            setIconImage(ImageIO.read(new File("./src/Images/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Races Fight");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < bars.length; i++) {
            bars[i] = new JProgressBar(0, 100);
            bars[i].setValue(i % 4 == 3 ? 92 : i % 4 == 2 ? 54 : i % 4 == 1 ? 30 : 10);
        }

        for (int i = 0; i < vidaBars.length; i++) {
            vidaBars[i] = new JProgressBar(0, 100);
            vidaBars[i].setValue(100);
            vidaBars[i].setStringPainted(true);
            vidaBars[i].setPreferredSize(new Dimension(200, 50));
        }

        stats = new JPanel(new BorderLayout());
        stat1 = new JPanel();
        stat2 = new JPanel();
        statText1 = new JPanel();
        statText2 = new JPanel();
        statBar1 = new JPanel();
        statBar2 = new JPanel();

        for (int i = 0; i < images.length; i++) {
            images[i] = new Image_play_window(i < 3 ? "./src/Images/Arc.jpg" : "./src/Images/Daga.jpg", 70, 70);
        }

        text1 = new JLabel("Power");
        text2 = new JLabel("Agility");
        text3 = new JLabel("Speed");
        text4 = new JLabel("Defense");
        text5 = new JLabel("Power");
        text6 = new JLabel("Agility");
        text7 = new JLabel("Speed");
        text8 = new JLabel("Defense");

        rondas = new JLabel("Ronda 1");
        rondas.setForeground(Color.RED);
        rondas.setFont(new Font("Arial", Font.BOLD, 20));

        statText1.setLayout(new BoxLayout(statText1, BoxLayout.Y_AXIS));
        statText1.add(text1);
        statText1.add(text2);
        statText1.add(text3);
        statText1.add(text4);

        statText2.setLayout(new BoxLayout(statText2, BoxLayout.Y_AXIS));
        statText2.add(text5);
        statText2.add(text6);
        statText2.add(text7);
        statText2.add(text8);

        statBar1.setLayout(new BoxLayout(statBar1, BoxLayout.Y_AXIS));
        for (int i = 0; i < 4; i++) {
            statBar1.add(bars[i]);
        }

        statBar2.setLayout(new BoxLayout(statBar2, BoxLayout.Y_AXIS));
        for (int i = 4; i < 8; i++) {
            statBar2.add(bars[i]);
        }

        stat1.setLayout(new BoxLayout(stat1, BoxLayout.X_AXIS));
        stat1.add(images[0]);
        
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
