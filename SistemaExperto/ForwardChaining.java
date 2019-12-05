import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class ForwardChaining{
	private Scanner keyboard = new Scanner(System.in);
	private int opcion, aux;
	private StringTokenizer antecedente, literales;
	private String regla,literal;
	private ArrayList<Integer> nRegla = new ArrayList<Integer>();
	//Si respuesta es true es que todo los hechos estan presente en la formula
	//de lo contrario es false
	private boolean respuesta, cardinalidad;
	//Nota: la variable proceso es para el proceso de forwardchainig dentro de un ciclo while,
	//si se agrega un hecho, proceso se volvera verdadero y seguira iterando. Esta variable
	//se inicializa en el ciclo
	public ForwardChaining(ArrayList<String> hechos, ArrayList<String> reglas){
		//Ciclo para ver si el usuario quiere seguir concluyendo
		do{	
			cardinalidad=false;
			for (int i=0; i<reglas.size(); i++) {
				regla = reglas.get(i);
				antecedente = new StringTokenizer(regla,"-");
				regla=antecedente.nextToken();

				literales = new StringTokenizer(regla, "&");
				//Ciclo para cada literal en los antecedentes de una regla
				do{
					literal = literales.nextToken();
					//Ciclo para ver si un hecho es igual a la literal
					for (int c=0; c<hechos.size(); c++) {
						if(literal.equals(hechos.get(c)))
							respuesta = true;
						else{
							respuesta = false;

						}
						//Si respuesta es verdadera, terminamos el ciclo para colaborar 
						//las demas literales del antecedente
						if(respuesta)
							c=hechos.size();
					}
				}while(literales.hasMoreElements() && respuesta);
				
				if(respuesta){
					literal = antecedente.nextToken();
					//Nota: El token antecedente divide la regla en antecedente y consecuente
					//por ello accederemos al consecuente por medio de este
					for (int c=0; c<hechos.size(); c++)
						if(literal.equals(hechos.get(c))){
							respuesta = false;
							c = hechos.size();
						}

					if(respuesta){
						hechos.add(literal);
						nRegla.add(i);
						//Ya que se agrego un nuevo hecho, el proceso seguira
						cardinalidad=true;
						System.out.println(hechos);
					}
				}

				for (int c=0; c<nRegla.size(); c++) {
					aux = nRegla.get(c);
					reglas.remove(aux);
					System.out.println(reglas);	
				}
				nRegla.clear();
			}
			if(cardinalidad){
				System.out.println("-------------------------");
				System.out.println("Desea seguir concluyendo?");
				System.out.println(" 1.- Si");
				System.out.println("!1.- No");
				opcion = keyboard.nextInt();
			}

			System.out.println(opcion+" && "+cardinalidad);
		}while(opcion==1 && cardinalidad);	
		System.out.println(reglas);
		System.out.println(hechos);		
	}
}