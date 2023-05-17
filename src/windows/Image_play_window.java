package windows;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Image_play_window extends JPanel {
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