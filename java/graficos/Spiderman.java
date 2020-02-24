package graficos;

import graficos.primitivas.Pixel;
import graficos.primitivas.Line;

import java.awt.image.BufferedImage;

public class Spiderman{
	private BufferedImage iSpiderman = new BufferedImage(17,27, BufferedImage.TYPE_INT_ARGB);
	
	public Spiderman(Pixel pixel, Line line, Colores c){
        //16x 26y
        line.drawLine(8,0,8,9,c.blanco,iSpiderman,pixel);
        pixel.drawPixel(7,0,c.rojo,iSpiderman); pixel.drawPixel(9,0,c.rojo,iSpiderman);
        line.drawLine(6,1,8,1,c.rojo,iSpiderman,pixel);  line.drawLine(9,1,11,1,c.rojo,iSpiderman,pixel);
        line.drawLine(5,2,8,2,c.rojo,iSpiderman,pixel);  line.drawLine(9,2,12,2,c.rojo,iSpiderman,pixel);
        line.drawLine(4,3,8,3,c.rojo,iSpiderman,pixel);  line.drawLine(9,3,13,3,c.rojo,iSpiderman,pixel);
        line.drawLine(3,4,6,4,c.rojo,iSpiderman,pixel);  line.drawLine(11,4,14,4,c.rojo,iSpiderman,pixel);
        
        pixel.drawPixel(2,4,c.azul,iSpiderman); pixel.drawPixel(14,4,c.azul,iSpiderman);
        pixel.drawPixel(4,5,c.rojo,iSpiderman); pixel.drawPixel(12,5,c.rojo,iSpiderman);
        line.drawLine(1,5,3,5,c.azul,iSpiderman,pixel);  line.drawLine(13,5,16,5,c.azul,iSpiderman,pixel);
        
        line.drawLine(0,6,4,6,c.azul,iSpiderman,pixel);  line.drawLine(13,6,17,6,c.azul,iSpiderman,pixel);
        line.drawLine(0,7,3,7,c.azul,iSpiderman,pixel);  line.drawLine(14,7,17,7,c.azul,iSpiderman,pixel);

        line.drawLine(5,7,8,7,c.rojo,iSpiderman,pixel);  line.drawLine(10,7,13,7,c.rojo,iSpiderman,pixel);
        line.drawLine(4,8,8,8,c.rojo,iSpiderman,pixel);  line.drawLine(10,8,14,8,c.rojo,iSpiderman,pixel);
        pixel.drawPixel(7,7,c.blanco,iSpiderman); pixel.drawPixel(9,7,c.blanco,iSpiderman);
        
        pixel.drawPixel(3,9,c.rojo,iSpiderman);    pixel.drawPixel(4,9,c.rojo,iSpiderman);    pixel.drawPixel(5,9,c.azul,iSpiderman);
        pixel.drawPixel(12,9,c.rojo,iSpiderman);   pixel.drawPixel(13,9,c.rojo,iSpiderman);   pixel.drawPixel(11,9,c.azul,iSpiderman);
        
        pixel.drawPixel(2,10,c.rojo,iSpiderman);    pixel.drawPixel(3,10,c.rojo,iSpiderman);    pixel.drawPixel(4,10,c.azul,iSpiderman);
        pixel.drawPixel(13,10,c.rojo,iSpiderman);   pixel.drawPixel(14,10,c.rojo,iSpiderman);   pixel.drawPixel(12,10,c.azul,iSpiderman);
        
        pixel.drawPixel(2,11,c.rojo,iSpiderman);    pixel.drawPixel(3,11,c.rojo,iSpiderman);    pixel.drawPixel(5,11,c.azul,iSpiderman);
        pixel.drawPixel(13,11,c.rojo,iSpiderman);   pixel.drawPixel(14,11,c.rojo,iSpiderman);   pixel.drawPixel(11,11,c.azul,iSpiderman);
        
        pixel.drawPixel(8,9,c.rojo,iSpiderman);
        
        line.drawLine(7,10,10,10,c.rojo,iSpiderman,pixel);
        pixel.drawPixel(6,11,c.rojo,iSpiderman);    pixel.drawPixel(7,11,c.rojo,iSpiderman); pixel.drawPixel(9,11,c.rojo,iSpiderman);    pixel.drawPixel(10,11,c.rojo,iSpiderman);
        line.drawLine(3,12,14,12,c.rojo,iSpiderman,pixel);
        pixel.drawPixel(6,13,c.rojo,iSpiderman);    pixel.drawPixel(5,13,c.rojo,iSpiderman); pixel.drawPixel(11,13,c.rojo,iSpiderman);    pixel.drawPixel(10,13,c.rojo,iSpiderman);

        //Cabeza
        line.drawLine(7,14,10,14,c.rojo,iSpiderman,pixel);
        line.drawLine(5,15,12,15,c.rojo,iSpiderman,pixel);
        line.drawLine(4,16,13,16,c.rojo,iSpiderman,pixel);
        line.drawLine(3,17,14,17,c.rojo,iSpiderman,pixel);
        line.drawLine(3,18,3,24,c.rojo,iSpiderman,pixel);
        line.drawLine(13,18,13,24,c.rojo,iSpiderman,pixel);

        pixel.drawPixel(4,18,c.rojo,iSpiderman); pixel.drawPixel(12,18,c.rojo,iSpiderman);
        line.drawLine(7,18,10,18,c.rojo,iSpiderman,pixel);
        pixel.drawPixel(8,19,c.rojo,iSpiderman);
        line.drawLine(7,20,10,20,c.rojo,iSpiderman,pixel);
        line.drawLine(6,21,11,21,c.rojo,iSpiderman,pixel);
        line.drawLine(5,22,12,22,c.rojo,iSpiderman,pixel);
        line.drawLine(4,23,13,23,c.rojo,iSpiderman,pixel);
        pixel.drawPixel(6,19,c.blanco,iSpiderman); pixel.drawPixel(5,19,c.blanco,iSpiderman); pixel.drawPixel(5,20,c.blanco,iSpiderman);
        pixel.drawPixel(10,19,c.blanco,iSpiderman); pixel.drawPixel(11,19,c.blanco,iSpiderman); pixel.drawPixel(11,20,c.blanco,iSpiderman);
        line.drawLine(4,24,13,24,c.rojo,iSpiderman,pixel);
        line.drawLine(6,25,11,25,c.rojo,iSpiderman,pixel);
	}

	public BufferedImage getSpiderman(){
    	return iSpiderman;
    }
}