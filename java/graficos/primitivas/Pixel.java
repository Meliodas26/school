package primitivasGraficas;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;

public class Pixel extends JPanel{

	private BufferedImage buffer;

	public Pixel(){
		buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	}

	public void drawPixel(int x, int y, Color c, BufferedImage image){
		buffer.setRGB(0, 0, c.getRGB());
		image.getGraphics().drawImage(buffer, x, y, this);
	}
	
}