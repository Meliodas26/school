public class PosicionCorrecta_Secuencial{
	Cuenta cuenta;
	Temporal temporal;
	int comparaciones,posicion;

	public PosicionCorrecta_Secuencial(Cuenta cuenta, Temporal temporal){
		this.cuenta = cuenta;
		this.temporal = temporal;
		ordenar();
	}

	public void ordenar(){
		for (int i=0; i<cuenta.nCuenta; i++) {
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

		/*
		for (int i=0; i<cuenta.nCuenta; i++) {
			System.out.println(temporal.id[i]+" - "+temporal.empty[i]);
		}
		*/
	}


}