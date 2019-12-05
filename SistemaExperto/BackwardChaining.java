import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BackwardChaining{
	private StringTokenizer tokenAntecedentes, tokenRegla;
	private String regla, antecedentes, consecuente, literal, supuesto, hecho;
	private ArrayList<Integer> nRegla = new ArrayList<Integer>();
	private ArrayList<String> reglas, hechos;
	private Scanner keyboard = new Scanner(System.in);
	private boolean respuesta = false, _copy=false;
	
	public BackwardChaining(ArrayList<String> reglas, ArrayList<String> hechos, String supuesto){
		this.reglas = reglas;
		this.hechos = hechos;
		this.supuesto = supuesto;
		run(supuesto);
	}

	public void run(String supuesto){
		for (int i=0; i<reglas.size(); i++) {
			regla = reglas.get(i);
			tokenRegla = new StringTokenizer(regla,"-");
			antecedentes = tokenRegla.nextToken();
			consecuente = tokenRegla.nextToken();
			if(consecuente.equals(supuesto)){
				System.out.println(antecedentes);
				System.out.println("--------------");
				tokenAntecedentes = new StringTokenizer(antecedentes, "&");
				do{
					System.out.println(literal);
					literal = tokenAntecedentes.nextToken();
					//Ciclo para ver si un hecho es igual a la literal
					for (int c=0; c<hechos.size(); c++) {
						hecho = hechos.get(c);
						if(literal.equals(hecho)){
							c=hechos.size();
							respuesta = true;
						}
						else{
							respuesta = false;
							System.out.println(literal);
							run(literal);
						}	
					}
					System.out.println("--------------");
				}while(tokenAntecedentes.hasMoreElements());
			}	
		}
		System.out.println(respuesta);
	}

	public boolean getRespuesta(){
		return respuesta;
	}

}