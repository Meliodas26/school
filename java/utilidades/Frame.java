package frame;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener{
    Tecla tecla;

    public Frame(Tecla tecla){
		setTitle("Avengers");
		setSize(700,700);
		setVisible(true);
		setResizable(false);
		setBackground(Color.black);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.black);
		addKeyListener(this);
        /*
            De esta manera hago que el objeto tecla de la clase
            Frame, apunte al objeto tecla de la clase Tecla
        */
		this.tecla = tecla;
	}

	public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        int keInt = ke.getKeyCode();
        tecla.accion = keInt;
        tecla.flag = true;
        /*
        Numero    Tecla
        37        Left
        38        Up
        39        Rigth
        40        Down
        27        Escape
        */
    }

    public void keyReleased(KeyEvent ke) {
    int keInt = ke.getKeyCode();
        
    }
}