package graficos;

import graficos.primitivas.*;

import java.awt.image.BufferedImage;

public class Template{
	private BufferedImage iTemplate = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
	
	public template(Pixel pixel, Colores c){

	}

	public BufferedImage getTemplate(){
    	return iTemplate;
    }
}