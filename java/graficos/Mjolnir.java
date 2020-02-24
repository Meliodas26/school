package graficos;

import graficos.primitivas.Pixel;
import graficos.primitivas.Line;

import java.awt.image.BufferedImage;

public class Mjolnir{
	private BufferedImage iMjolnir = new BufferedImage(41,39,BufferedImage.TYPE_INT_ARGB);
	
	public Mjolnir(Pixel pixel, Line line, Colores c){
        //22x, 39y
        line.drawLine(9,0,15,0,c.gris,iMjolnir,pixel);
        line.drawLine(2,1,21,1,c.gris,iMjolnir,pixel);
        pixel.drawPixel(1,2,c.gris,iMjolnir); pixel.drawPixel(21,2,c.gris,iMjolnir);
        line.drawLine(0,2,0,11,c.gris,iMjolnir,pixel);
        line.drawLine(22,2,22,11,c.gris,iMjolnir,pixel);
        line.drawLine(2,12,21,12,c.gris,iMjolnir,pixel);
        
    
        line.drawLine(2,2,21,2,c.plata,iMjolnir,pixel);
        for (int j=3; j<12; j++)
            line.drawLine(1,j,22,j,c.plata,iMjolnir,pixel);
        pixel.drawPixel(1,11,c.gris,iMjolnir); pixel.drawPixel(21,11,c.gris,iMjolnir);
        line.drawLine(8,10,15,10,c.gris,iMjolnir,pixel);
        line.drawLine(3,11,8,11,c.gris,iMjolnir,pixel);
        line.drawLine(16,11,21,11,c.gris,iMjolnir,pixel);
        for (int i=0; i<17; i++)
            line.drawLine(10,13+i,15,13+i,c.cafe,iMjolnir,pixel);
        pixel.drawPixel(10,14,c.negro,iMjolnir); pixel.drawPixel(14,14,c.negro,iMjolnir);
	}

	public BufferedImage getMjolnir(){
    	return iMjolnir;
    }
}