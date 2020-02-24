/*
En esta clase se llaman todas las clases 
de los graficos para dibujarlos en 
buffereds image
*/
package graficos;

import graficos.primitivas.*;

import java.awt.image.BufferedImage;

public class Graficos{

	//Graficas primitivas
        private Pixel pixel = new Pixel();
	    private Line line = new Line();
        private Circle circle = new Circle();
    
    //Para tener una paleta de colores mas amplia
        private Colores c = new Colores();
	
    //Graficos de fondo
        Fondo fondo;
        A a;
        //Escudo escudo;
        Mjolnir mjolnir;
        Spiderman spiderman;
        //iRed, iThor;
		//[] bifrost = new BufferedImage[8];
		//[] estrellas = new BufferedImage[8];
	
	//Personaje
		//iIronman, iPropulsoresM, iPropulsoresP, iVida;
	//Obstaculos
		//iAsteroide;

    public Graficos(){
    	fondo       = new Fondo         (pixel, line, c);
        a           = new A             (pixel, line, circle, c);
        mjolnir     = new Mjolnir       (pixel, line, c);
        spiderman   = new Spiderman     (pixel, line, c);
    }

    //Funciones get de graficos de fondo
        public BufferedImage getFondo(){
    	   return fondo.getFondo();
        }

        
        public BufferedImage getA(){
            return a.getA();
        }

        public BufferedImage getMjolnir(){
            return mjolnir.getMjolnir();
        }

        public BufferedImage getSpiderman(){
            return spiderman.getSpiderman();
        }
        
}