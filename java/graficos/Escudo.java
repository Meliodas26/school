package graficos;

import graficos.primitivas.Pixel;
import graficos.primitivas.Line;
import graficos.

import java.awt.image.BufferedImage;

public class Escudo{
	private BufferedImage iEscudo = new BufferedImage(41,39,BufferedImage.TYPE_INT_ARGB);
	
	public Escudo(Pixel pixel, Line line){
        //13 pixeles de escudo, 14 left,right
        //13 escudo 13 up,down
        //1ro
        exi=14; eyi=0; epixeles=12;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        pixeles(3, 4, cs.rojo);
        pixeles(3, 2, cs.rojo);
        pixeles(1,cs.rojo);
        pixeles(1, 2, cs.rojo);
        pixeles(1, 2, cs.rojo);
        pixeles(1,cs.rojo);
        pixeles(1, 2, cs.rojo);
        pixeles(2,cs.rojo);
        pixeles(1, 2, cs.rojo);
        pixeles(11,cs.rojo);
        //2do
        exi=15; eyi=4; epixeles=10;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        pixeles(2,4,cs.blanco);
        pixeles(3,2,cs.blanco);
        pixeles(1,2,cs.blanco);
        pixeles(1,cs.blanco);
        pixeles(1,2,cs.blanco);
        pixeles(1,cs.blanco);
        pixeles(10,cs.blanco);
        //3ro
        exi=16; eyi=8; epixeles=8;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        for (int i=0; i<3; i++) {
            pixeles(1,4,cs.rojo);
            pixeles(1,cs.rojo);
        }
        pixeles(1,2,cs.rojo);
        pixeles(8,cs.rojo);
        


        //Inverso
        exi=14; eyi=39; epixeles=12;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        pixelesAbajo(3, 4, cs.rojo);
        pixelesAbajo(3, 2, cs.rojo);
        pixelesAbajo(1,cs.rojo);
        pixelesAbajo(1, 2, cs.rojo);
        pixelesAbajo(1, 2, cs.rojo);
        pixelesAbajo(1,cs.rojo);
        pixelesAbajo(1, 2, cs.rojo);
        pixelesAbajo(2,cs.rojo);
        pixelesAbajo(1, 2, cs.rojo);
        pixelesAbajo(1,cs.rojo);
        //2do
        exi=15; eyi=35; epixeles=10;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        pixelesAbajo(2,4,cs.blanco);
        pixelesAbajo(3,2,cs.blanco);
        pixelesAbajo(1,2,cs.blanco);
        pixelesAbajo(1,cs.blanco);
        pixelesAbajo(1,2,cs.blanco);
        pixelesAbajo(1,cs.blanco);
        pixelesAbajo(10,cs.blanco);
        //3ro
        exi=16; eyi=31; epixeles=8;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.rojo);
        for (int i=0; i<3; i++) {
            pixelesAbajo(1,4,cs.rojo);
            pixelesAbajo(1,cs.rojo);
        }
        pixelesAbajo(1,2,cs.rojo);
        pixelesAbajo(8,cs.rojo);

        //Azul
        line(17, 12, 24, 12, cs.azul);
        line(16, 13, 25, 13, cs.azul);
        line(15, 14, 26, 14, cs.azul);
        line(14, 15, 27, 15, cs.azul);
        line(13, 16, 28, 16, cs.azul);
        line(12, 17, 29, 17, cs.azul);
        line(12, 18, 29, 18, cs.azul);
        line(12, 19, 29, 19, cs.azul);
        line(12, 20, 29, 20, cs.azul);
        line(12, 21, 29, 21, cs.azul);
        line(12, 22, 29, 22, cs.azul);
        line(12, 23, 29, 23, cs.azul);
        line(13, 24, 28, 24, cs.azul);
        line(14, 25, 27, 25, cs.azul);
        line(15, 26, 26, 26, cs.azul);
        line(16, 27, 25, 27, cs.azul);
        line(17, 28, 24, 28, cs.azul);

        //Estrellas
        drawPixel(20,13,cs.blanco);
        drawPixel(20,14,cs.blanco);
        exi=19; eyi=15; epixeles=3;
        exf=exi+epixeles;
        line(exi, eyi, exf, eyi, cs.blanco);
        pixeles(1,cs.blanco);
        pixeles(1,8,cs.blanco);
        exi++;
        eyi++;
        line(exi, eyi, exi+9, eyi, cs.blanco);
        exi++;
        eyi++;
        line(exi, eyi, exi+7, eyi, cs.blanco);
        exi++;
        eyi++;
        line(exi, eyi, exi+5, eyi, cs.blanco);
        exi--;
        eyi++;
        line(exi, eyi, exi+7, eyi, cs.blanco);
        exi--;
        eyi++;
        line(exi, eyi, exi+8, eyi, cs.blanco);
        line(16,23,25,23,cs.blanco);
        line(15,24,18,24,cs.blanco); line(23,24,26,24,cs.blanco);
        drawPixel(15, 25,cs.blanco); drawPixel(25,25,cs.blanco);
	}

	public BufferedImage getEscudo(){
    	return iEscudo;
    }
}