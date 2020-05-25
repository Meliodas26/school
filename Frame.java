import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame implements ActionListener{
	public static void main(String[] args) {
		Frame frame = new Frame();
	}

	public Frame(){
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Ordenamiento de cuentas bancarias", JLabel.CENTER);
		title.setFont(new Font("DejaVu Sans", Font.BOLD, 18));

		JLabel subTitle = new JLabel("Secuencial vs Concurrente", JLabel.CENTER);
		subTitle.setFont(new Font("DejaVu Sans", 1, 18));		
		subTitle.setForeground(Color.blue);
		
		JButton consultar = new JButton("Consultar-Cuentas");
		consultar.setBackground(Color.black);
		consultar.setForeground(Color.white);
		JButton secuencial = new JButton("Secuencial");
		secuencial.setBackground(Color.red);
		secuencial.setForeground(Color.white);
		JButton concurrente = new JButton("Concurrente");
		concurrente.setBackground(Color.green);
		concurrente.setForeground(Color.white);
    	
    	panel.add(title);
    	panel.add(subTitle);
    	panel.add(consultar);
    	panel.add(secuencial);
    	panel.add(concurrente);

        add(panel);

        setTitle("Proyecto - 2doParcial");
        setSize(420,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	//Funcionalidad a los botones
  	public void actionPerformed(ActionEvent e) {

  	}
}