import primitivasGraficas.Line;

import java.awt.image.BufferedImage;
import java.awt.Color; 

public class Fondo{
    private Line line;

    public Fondo(BufferedImage image, int xy){
    	line = new Line();
    	
    	for(int i=0; i<xy; i++)
    		line.drawLine(i, 0, i, xy, Color.blue, image);
    }
}