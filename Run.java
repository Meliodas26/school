import javax.swing.JOptionPane;
public class Run{
    public static void main(String[] args){
 		System.out.println("Hola mundo");
		JOptionPane.showMessageDialog(null, "Hola mundo 2");   	

        Move move = new Move();
        Panel panel = new Panel(move);
        Frame frame = new Frame(move);
        frame.add(panel);
        panel.inicio();
    }
}
