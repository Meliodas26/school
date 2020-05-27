public class Temporal{
	int[] id;
	String [] name;
	int [] saldo;
	boolean[] empty;

	public Temporal(int nCuenta){
		
		id = new int[nCuenta];
		name = new String[nCuenta];
		saldo = new int[nCuenta];
		empty = new boolean[nCuenta];

		for (int i=0; i<nCuenta; i++) {
			id[i] = 0;
			name[i] = "";
			saldo[i] = 0;
			empty[i] = true;
		}
	}

	public void clearTemporal(){

	}
}