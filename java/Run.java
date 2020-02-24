import graficos.Graficos;
import utilidades.*;

public class Run{
    public static void main(String[] args){
        
        Soundtrack soundtrack = new Soundtrack();
        soundtrack.onEspera();

        Tecla tecla = new Tecla(0);
        /*
        	Se pasa por referencia el objeto tecla
        	ya que en el Frame se tienen las funciones keylistener
        	y de esta manera pueda tener un control de que teclas
        	fueron presionadas por el usuario
        */
        Frame frame = new Frame(tecla);
        
        Graficos graficos = new Graficos();
            frame.getGraphics().drawImage(graficos.getFondo(), 0, 0, frame);
            frame.getGraphics().drawImage(graficos.getA(), 0, 37, frame);
            frame.getGraphics().drawImage(graficos.getMjolnir(), 150, 225, frame);
            frame.getGraphics().drawImage(graficos.getSpiderman(), 192, 160, frame);
        /*
        while(true){
        	System.out.print("");
        	if (tecla.flag) {
        		System.out.println(tecla.accion);
        		tecla.flag = false;
        	}

        }
        */
    }
}
