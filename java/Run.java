import java.awt.image.BufferedImage;

public class Run{
    public static void main(String[] args){
        
        Tecla tecla = new Tecla(0);
        Soundtrack soundtrack = new Soundtrack();
        soundtrack.onEspera();
        /*
        	Se pasa por referencia el objeto tecla
        	ya que en el Frame se tienen las funciones keylistener
        	y de esta manera pueda tener un control de que teclas
        	fueron presionadas por el usuario
        */
        Frame frame = new Frame(tecla);

        //Graficos
    	BufferedImage iFondo,bifrost;

        iFondo = new BufferedImage(700,700, BufferedImage.TYPE_INT_ARGB);
        Fondo fondo = new Fondo(iFondo,700);
        frame.getGraphics().drawImage(iFondo, 0, 0, frame);
        
        while(true){
        	System.out.print("");
        	if (tecla.flag) {
        		System.out.println(tecla.accion);
        		tecla.flag = false;
        	}

        }
    }
}
