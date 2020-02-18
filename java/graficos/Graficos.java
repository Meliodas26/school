package graficos;

import primitivas.*;

import java.awt.image.BufferedImage;

public class Graficos{

	//Graficas primitivas
	private Line line = new Line();
	
    //Graficos de fondo
        Fondo fondo;
		
        private BufferedImage iA, iEscudo, iMjolnir, iSpiderman, iRed, iThor;
		private BufferedImage [] bifrost = new BufferedImage[8];
		private BufferedImage [] estrellas = new BufferedImage[8];
	
	//Personaje
		private BufferedImage iIronman, iPropulsoresM, iPropulsoresP, iVida;
	//Obstaculos
		private BufferedImage iAsteroide;

    public Graficos(){
    	setFondo();
    }

    //Funciones set de graficos de fondo
        public void setFondo(){
            fondo = new Fondo(line);
        }

    //Funciones get de graficos de fondo
        public BufferedImage getFondo(){
    	   return fondo.getFondo();
        }
}