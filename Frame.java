import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener{
	private Move move;
	public Frame(Move move){
		setTitle("Avengers");
		setSize(700,700);
		setVisible(true);
		setResizable(false);
		setBackground(Color.black);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.black);
		addKeyListener(this);
		this.move = move;
	}

	public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if(key==39){//derecha
            move.rigth=true;
        }
        if(key==37){//izquierda
            move.left=true;
        }
        if(key ==38 ){
            move.up=true;
        }
        if(key == 40 ){
            move.down=true;
        }
    }

    public void keyReleased(KeyEvent ke) {
    int key = ke.getKeyCode();
        if(key==39){//derecha
            move.rigth=true;
        }
        if(key==65)  {//izquierda
            move.left=true;
        }
        if(key==38)  {//Arriba
            move.up=true;
        }
        if(key==40)  {//Abajo
            move.down=true;
        }
    }
}