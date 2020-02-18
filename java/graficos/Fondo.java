package graficos;
import graficos.primitivas.Line;

import java.awt.image.BufferedImage;
import java.awt.Color; 

public class Fondo{
	private BufferedImage iFondo = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);

    public Fondo(Line line){
    	for(int i=0; i<700; i++)
    		line.drawLine(i, 0, i, 700, Color.blue, iFondo);
    }

    public BufferedImage getFondo(){
    	return iFondo;
    }
}