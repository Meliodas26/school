//Dibuja la A de Avengers
package graficos;

import graficos.primitivas.*;

import java.awt.image.BufferedImage;

public class A{
	private BufferedImage iA = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
	
	public A(Pixel pixel, Line line, Circle circle, Colores c){
        circle.circleThickness (325, 300, 225, 010, c.blanco, iA, pixel);
        line.drawLineThickness (150, 550, 400, 050, 20, c.blanco, iA, pixel);
        line.drawLineThickness(400, 050, 400, 450, 20, c.blanco, iA, pixel);
        line.drawLineThickness(235, 375, 375, 375, 20, c.blanco, iA, pixel);
    }

    public BufferedImage getA(){
    	return iA;
    }
	
}