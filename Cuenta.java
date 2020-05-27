import java.util.Random;
public class Cuenta{
	int nCuenta;
	int [] id;
	String [] name;
	int [] saldo;

	public Cuenta(int nCuenta){
		this.nCuenta=nCuenta;
		id = new int[nCuenta];
		name = new String[nCuenta];
		saldo = new int[nCuenta];

		Random r = new Random();

		for (int i = 0; i<nCuenta; i++){
			id[i] = i+1;
			name[i] = crearNombre();
			saldo[i] = r.nextInt(10000)+100;
		}
	}

	public String crearNombre(){
		String [] name = {"Aldo","Alex","Andrea","Gerardo","Cesar","Carlos","Edgar","Erick","Gustavo","Jorge","Roberto","Eunice","Pilar","Araceli","Gricelda","Salvador","Ernestina","Karla","Carmelita","Ashley","Dafne","Argel","Cristian","Viridiana","Analia","Angelica", "Martin", "Marcos", "Luis", "Juan"};
		String [] lastName = {"Gutierrez","Rincon","Rodriguez","Flores","Silva","Estrada","Vargas","Lopez","Garibay","Fernandez","Ramirez","Delgado","Pitt","Lozano","Alvarez","Vazquez","Guevara","Holland","Anaya","Arechiga"};
		String fullName = "";
		Random r = new Random();
		int pos = r.nextInt(29)+1;
		fullName = name[pos]+" ";
		pos = r.nextInt(19)+1;
		fullName += lastName[pos];
		return fullName;
	}

}