//Dibuja una imagen de 700x700 negra para limpiar el frame
package graficos;

import graficos.primitivas.Line;

import java.awt.image.BufferedImage;

public class Fondo{
	private BufferedImage iFondo = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);

    public Fondo(Line line, Colores c){
    	for(int i=0; i<700; i++)
    		line.drawLine(i, 0, i, 700, c.negro, iFondo);
    }

    public BufferedImage getFondo(){
    	return iFondo;
    }
}