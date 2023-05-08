package mainPackage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Principal {
	private BufferedImage img;
	public Principal() {
		super();
		try {
			img = ImageIO.read(new File("./src/Images/Daga.jpg"));
			System.out.println(img.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Principal();
	}
}
