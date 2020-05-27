public class PosicionCorrecta_Concurrente extends Thread{
	Cuenta cuenta;
	Temporal temporal;
	int posicion, begin, end;

	public PosicionCorrecta_Concurrente(Cuenta cuenta, Temporal temporal, int begin, int end){
		this.cuenta = cuenta;
		this.temporal = temporal;
		this.begin = begin;
		this.end = end;
	}

	public void run(){
		for (int i=begin; i<end; i++) {

			posicion = 0;
			for (int j=0; j<cuenta.nCuenta; j++) {
				if(i != j){
					if(cuenta.saldo[i] > cuenta.saldo[j])
						posicion++;
				}
			}
			while(!temporal.empty[posicion]){
				posicion++;
			}
			temporal.id[posicion] = cuenta.id[i];
			temporal.name[posicion] = cuenta.name[i];
			temporal.saldo[posicion] = cuenta.saldo[i];
			temporal.empty[posicion] = false;
		}
	}
}