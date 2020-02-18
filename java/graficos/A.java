//Dibuja la A de Avengers
package graficos;

import graficos.primitivas.*;

import java.awt.image.BufferedImage;

public class A{
	private BufferedImage iA = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
	
	public A(Line line, Colores c){
        //circleThickness (325, 300, 225, 010, c.blanco);
        line.drawLine(200, 550, 150, 50, c.blanco, iA);
        //line.drawLineThickness(400, 050, 400, 450, 20, c.blanco, iA);
        //line.drawLineThickness(235, 375, 375, 375, 20, c.blanco, iA);
    }

    public BufferedImage getA(){
    	return iA;
    }
	
}