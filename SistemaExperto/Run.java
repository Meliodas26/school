import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Run{
	static int nLines;
	static String formula, text, route = "Formulas.txt", formulas="", option, txt="", firstFormula;
	static boolean mistake=false;
	static Set<String> atoms = new HashSet<String>();
	static Scanner keyboard;


	public static void main(String[] args) {
		try{
			route = args[0];
		}catch (Exception e){
			System.out.println("Ingrese el nombre del archivo");
		}
		

		File_ file = new File_();
		mistake = file.setText(route);
		
		if(!mistake){
			text = file.getText();
			nLines = file.getNLines();

			Line line = new Line(text, nLines);
			ZombieParenthesis zombieParenthesis = new ZombieParenthesis();
			Zombie zombie = new Zombie();
			Atom atom = new Atom();
			//zombie is to check the sintax
			for (int i=0; i<nLines; i++){
				formula = line.getLine(i);
				formula = formula.replace("\t", "");
				formula = formula.replace(" ", "");
				mistake = zombie.sleeping(formula, i+1);
				if(!mistake)
					mistake = zombieParenthesis.sleeping(formula, i+1);
				if(!mistake){
					atom.setAtoms(formula);	
					formulas += "("+formula+")&";
					txt += formula+"\n";
					
					if(i==0)
						firstFormula = formula;
				}
			}
			if(!mistake){
				System.out.println("Todas las formulas estan bien formadas.");
				atoms = atom.getAtoms();
				//System.out.println("Los atomos son:\n"+atoms);
				//System.out.println("-------------------------");
				//Tree
				//To delete the last &
				formulas=formulas.substring(0, formulas.length()-1);
				Arbol tree = new Arbol(formulas);
				tree.formaNormal();
				String arbol = tree.inorden("");

				System.out.println("Arbol:\n"+arbol);
				System.out.println("-------------------------");

				String[] aux=arbol.split("&");
	            String[][] literales = new String[aux.length][];
	            
	            for (int i=0;i<=aux.length-1;i++){
	                literales[i]=aux[i].split("\\|");
	            }
	            //System.out.println(Arrays.deepToString(literales));
	            //System.out.println("-------------------------");
	            List antecedentes; 
	            Set<Reglas> reglas = new HashSet<>();
	            String[] item;
	           	//Para obtener cuantas reglas hay en cada rama
	            String reglasRama;
	            ArrayList<String> reglasArrayList = new ArrayList<String>();
	            String regla="";
	            for (int i=0;i<=literales.length-1;i++){

	                for (int j = 0; j <= literales[i].length-1; j++) {
	                    antecedentes = new ArrayList(Arrays.asList(literales[i]));
	                    antecedentes.remove(literales[i][j]);
	                    item = (String[]) antecedentes.toArray(new String[antecedentes.size()]);
	                    int k=0;

	                    for (String items: item ) {
	                        if(item[k].charAt(0)=='!'){
	                            item[k]=item[k].substring(1,item[k].length());
	                        }else{
	                            item[k]="!"+item[k];
	                        }
	                		regla=regla+item[k]+"&";
	                        k++;
	                    }
	                    regla = regla.substring(0, regla.length()-1);
	                    regla = regla+"-"+literales[i][j];
	                    reglasArrayList.add(regla);
	                    regla="";
	                    reglas.add(new Reglas(item,literales[i][j]));
	                }
	            }

	            
	            System.out.println(reglasArrayList);
	            System.out.println("-------------------------");

	            //Metodo para solicitar los hechos al usuario y guardarlos en un arrayList
	            Hechos hechos = new Hechos();
	            System.out.println("-------------------------");
	            ForwardChaining forwardchaining = new ForwardChaining(hechos.getHechos(), reglasArrayList);
	            
	            //Backward chaining
	            //hechos.supuesto();
	            //BackwardChaining backwardchaining = new BackwardChaining(reglasArrayList, hechos.getHechos(), hechos.getSupuesto());
	            //boolean resultadoBack = backwardchaining.getRespuesta();
	            file = new File_();
	            mistake = file.setText("Hechos");

	            if(!mistake){
					text = file.getText();
					nLines = file.getNLines();
					String [][] hecho = new String [nLines][2];
					Diccionario diccionario = new Diccionario(hecho, text, nLines);
	            	diccionario.getHecho();

	            	ArrayList<String> alHechos = hechos.getHechos();
	            	int nHechos = alHechos.size();
	            	System.out.println("Tus hechos son: ");
	            	for (int i=0; i<nHechos; i++) {
	            		for (int j=0; j<nLines; j++) {
	            			if(hecho[j][0].equals(alHechos.get(i))){
	            				System.out.println(hecho[j][1]);
	            				j=nLines;
	            			}
	            		}
	            	}
	            	/*
	            	if(resultadoBack){
	            		System.out.println("Es cierto tu supuesto de que eres");
	            	}else{
	            		System.out.println("No es cierto tu supuesto de que eres ");
	            	}
	            	for (int j=0; j<nLines; j++) {
            			if(hecho[j][0].equals(hechos.getSupuesto())){
            				System.out.println(hecho[j][1]);
            				j=nLines;
            			}
            		}
					*/
	            }
			}
		}
	}
}