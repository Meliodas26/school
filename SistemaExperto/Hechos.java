import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Hechos{
	
	private Scanner keyboard = new Scanner(System.in);
	//Para guardar todos los hechos que introduzca el usuario
	private String hechosJuntos="", supuesto;
	private int nHechos;
	private StringTokenizer token;
	ArrayList<String> hechos = new ArrayList<String>();
	public Hechos(){
		System.out.println("Escribe tus hechos:");
		hechosJuntos = keyboard.nextLine();
		token = new StringTokenizer(hechosJuntos, " ");
		nHechos= token.countTokens();
		while(token.hasMoreElements()){
			hechos.add(token.nextToken());
		}
	}

	public void supuesto(){
		System.out.println("Escribe tu supuesto:");
		supuesto = keyboard.nextLine();
	}

	public ArrayList<String> getHechos(){
		return hechos;
	}

	public String getSupuesto(){
		return supuesto;
	}
}