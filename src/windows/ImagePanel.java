package windows;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import playerClasses.Player;

public class ImagePanel extends JPanel{
	private BufferedImage image;
	private String warrior[];
	
	public ImagePanel(int id, Player player) {
		
		try {
			warrior = player.getData().getWarrior(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		try {
            image = ImageIO.read(new File(warrior[2]));
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
		setPreferredSize(getMaximumSize());
		
	}
	
	public ImagePanel(String imagePath) {
		try {
			image = ImageIO.read(new File(imagePath));
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		setPreferredSize(getMaximumSize());
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
		Graphics2D g2d = (Graphics2D) g.create();
		
		g2d.translate(10, -40); 
		g2d.drawImage(image, 0, 0, this);
    }
}
