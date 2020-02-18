/*
En esta clase se llaman todas las clases 
de los graficos para dibujarlos en 
buffered image
*/
package graficos;

import graficos.primitivas.*;

import java.awt.image.BufferedImage;

public class Graficos{

	//Graficas primitivas
	   private Line line = new Line();
       private Pixel pixel = new Pixel();
    
    //Para tener una paleta de colores mas amplia
    private Colores c = new Colores();
	
    //Graficos de fondo
        Fondo fondo;
        A a;
		
        //iEscudo, iMjolnir, iSpiderman, iRed, iThor;
		//[] bifrost = new BufferedImage[8];
		//[] estrellas = new BufferedImage[8];
	
	//Personaje
		//iIronman, iPropulsoresM, iPropulsoresP, iVida;
	//Obstaculos
		//iAsteroide;

    public Graficos(){
    	fondo = new Fondo(line, c);
        //a = new A();
    }

    //Funciones get de graficos de fondo
        public BufferedImage getFondo(){
    	   return fondo.getFondo();
        }

        /*
        public BufferedImage setA(){
            return a.getA();
        }
        */
}