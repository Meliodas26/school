package graficos;

import graficos.primitivas.*;

import java.awt.image.BufferedImage;

public class Graficos{

	//Graficas primitivas
	   private Line line = new Line();
       private Pixel pixel = new Pixel();
	
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
    	fondo = new Fondo(line);
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