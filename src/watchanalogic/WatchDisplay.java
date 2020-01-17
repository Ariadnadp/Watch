package watchanalogic;

import java.awt.*;
import java.io.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.*;

public class WatchDisplay extends JPanel {
    private final Image background;
    private Point[] points;

    public WatchDisplay() {
        this.background = loadBackground();
        this.points = new Point[0];
    }
    
    // Method paint
    public void paint(Point[] points){
        this.points = points;
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(background, 0, -1, null);
        g.setColor(Color.black);
        int width = 1;
        for(Point point: points){
            g2(g).setStroke(new BasicStroke(width));
            g2(g).drawLine(ox(),oy(),ox() + point.x, oy() -point.y);
            width++;
        }
    }

    // Method to load the background
    private Image loadBackground() {
        try {
            return ImageIO.read(new File ("reloj.jpg"));
        } catch (IOException ex){
            return null;
        }
    }

    private int ox() {
        return this.getWidth()/2;
    }

    private int oy() {
        return this.getHeight()/2;
    }

    // Method Graphics2D
    private Graphics2D g2(Graphics g) {
        return (Graphics2D) g;
    }
    
    
}
