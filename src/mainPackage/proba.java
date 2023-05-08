package mainPackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;




//Ignorad este archivo
public class proba extends JPanel {
    private float value = 0;
    private Color color;
    public proba(float vida_total,float vida_actual) {
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Progress Bar");
        proba progressBar = new proba(100,100);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        frame.add(progressBar);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        

    }
}
