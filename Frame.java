import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame implements ActionListener{
	//Maximo secuencial accounts = 100000;
	static int nucleos, threads, accounts = 10000;
	static Cuenta cuenta;

	static JPanel header,right;
	static JScrollPane left;
	static JLabel title,subTitle,nNucleo,recomendacion, nThread, nAccount;
	static JButton consultar,secuencial,concurrente, addThread, rmThread, addAccount, rmAccount;

	static TableCuenta tableCuenta;
	static TableComparacion tableComparacion;

	//Ordenamientos
	static PosicionCorrecta_Secuencial oSecuencial;
	static PosicionCorrecta_Concurrente[] oConcurrente;

	static Temporal temporal;
	//Secuencial
	long begin, end;
	double time;
			


	public static void main(String[] args) {
		//Conseguir informacion del hardware(equipo)
		Runtime hardware = Runtime.getRuntime();
		//Numero de nucleros
		nucleos = hardware.availableProcessors();
		threads = nucleos*10;

		//Creacion de la interfaz rafica
		Frame frame = new Frame();

		cuenta = new Cuenta(accounts);

	}

	public Frame(){
		setLayout(null);

		header = new JPanel();
		header.setBounds(90,0, 420,100);
		initHeader();
		consultar.addActionListener(this);
		secuencial.addActionListener(this);
		concurrente.addActionListener(this);

		tableCuenta = new TableCuenta();
		left = new JScrollPane(tableCuenta.getTable());
		left.setBounds(0,100,420,600);
		left.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		left.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		right = new JPanel();
		right.setBounds(420,100,200,400);
		initRight();
		addThread.addActionListener(this);
		rmThread.addActionListener(this);
		addAccount.addActionListener(this);
		rmAccount.addActionListener(this);

        add(header);
        add(left);
        add(right);

        setTitle("Proyecto - 2doParcial");
        setSize(620,735);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
	}

	//Funcionalidad a los botones
  	public void actionPerformed(ActionEvent e) {
  		if (e.getSource() == consultar){
  			tableCuenta.putData(cuenta);
  		}

  		if (e.getSource() == secuencial){
  			begin = System.currentTimeMillis();
  			temporal = new Temporal(cuenta.nCuenta);
  			oSecuencial = new PosicionCorrecta_Secuencial(cuenta, temporal);
  			end = System.currentTimeMillis();
  			time = (end - begin);
  			tableCuenta.putDataOrdenadamente(cuenta.nCuenta,temporal);
  			tableComparacion.putTime(1,time);
  		}

  		if (e.getSource() == concurrente){

  			begin = System.currentTimeMillis();
  			temporal = new Temporal(cuenta.nCuenta);
  			
  			oConcurrente = new PosicionCorrecta_Concurrente[threads];
  			
  			int tasksThread,beginThread,endThread=0;
  			beginThread = 0;
  			tasksThread = accounts/threads;
  			
  			if((accounts%threads) == 0){
  				endThread = tasksThread;
  				for (int i=0; i<threads; i++) {
  					oConcurrente[i] = new PosicionCorrecta_Concurrente(cuenta, temporal, beginThread,endThread);
  					oConcurrente[i].start();	
  					beginThread = endThread;
  					endThread += tasksThread;
  				}
  			}else{
  				int pTasksThread = accounts%threads;
  				for (int i=0; i<threads; i++) {
  					if(pTasksThread>0){
  						endThread += (tasksThread+1);	
  						pTasksThread--;
  					}
  					else
  						endThread += tasksThread;
  					oConcurrente[i] = new PosicionCorrecta_Concurrente(cuenta, temporal, beginThread,endThread);
  					oConcurrente[i].start();	
  					beginThread = endThread;
  				}
  			}

  			try{
				for (int i=0; i<threads; i++)
					oConcurrente[i].join();
			}catch(Exception ex){}

  			end = System.currentTimeMillis();
  			time = (end - begin);
  			tableCuenta.putDataOrdenadamente(cuenta.nCuenta,temporal);
  			tableComparacion.putTime(2,time);
  		}

  		if(e.getSource() == addThread){
  			threads++;
  			nThread.setText("Threads:"+threads);
  		}
  		if(e.getSource() == rmThread){
  			threads--;
  			nThread.setText("Threads:"+threads);
  		}

  		if(e.getSource() == addAccount){
  			accounts++;
  			nAccount.setText("Cuentas:"+accounts);
  		}
  		if(e.getSource() == rmAccount){
  			accounts--;
  			nAccount.setText("Cuentas:"+accounts);
  		}
  	}

  	public void initHeader(){
  		title = new JLabel("Ordenamiento de saldos", JLabel.CENTER);
		title.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		
		subTitle = new JLabel("Secuencial vs Concurrente", JLabel.CENTER);
		subTitle.setFont(new Font("DejaVu Sans", 1, 18));		
		subTitle.setForeground(Color.blue);
		
		consultar = new JButton("Consultar-Cuentas");
		consultar.setBackground(Color.black);
		consultar.setForeground(Color.white);
		
		secuencial = new JButton("Secuencial");
		secuencial.setBackground(Color.red);
		secuencial.setForeground(Color.white);
		
		concurrente = new JButton("Concurrente");
		concurrente.setBackground(Color.green);
		concurrente.setForeground(Color.white);
		
		header.add(title);
    	header.add(subTitle);
    	header.add(consultar);
    	header.add(secuencial);
    	header.add(concurrente);
  	}

  	public void initRight(){
  		tableComparacion = new TableComparacion();
		
		nNucleo = new JLabel("Su equipo tiene: "+nucleos+" nucleos", JLabel.CENTER);
		nNucleo.setFont(new Font("DejaVu Sans", 1, 10));	
		
		recomendacion = new JLabel("Se recomienda 10 hilos por nucleo", JLabel.CENTER);
		recomendacion.setFont(new Font("DejaVu Sans", 1, 10));	

		addThread = new JButton("+");
		addThread.setBackground(Color.green);
		
		rmThread = new JButton("-");
		rmThread.setBackground(Color.red);
		
		nThread = new JLabel("Threads: "+threads, JLabel.CENTER);
		nThread.setFont(new Font("DejaVu Sans", 1, 14));

		addAccount = new JButton("+");
		addAccount.setBackground(Color.green);

		rmAccount = new JButton("-");
		rmAccount.setBackground(Color.red);

		nAccount = new JLabel("Cuentas: "+accounts, JLabel.CENTER);
		nAccount.setFont(new Font("DejaVu Sans", 1, 10));


		right.add(tableComparacion.getTable());
		right.add(nNucleo);
		right.add(recomendacion);
		right.add(addThread);
		right.add(rmThread);
		right.add(nThread);
		right.add(addAccount);
		right.add(rmAccount);
		right.add(nAccount);
  	}
}