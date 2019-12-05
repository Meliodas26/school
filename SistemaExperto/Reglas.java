import java.util.Arrays;

public class Reglas {
    
    String[] Antecedentes;
    String   Consecuencia;
    
    public Reglas(String[] antecedentes,String  consecuencia){
        Antecedentes=antecedentes;
        consecuencia = consecuencia.replaceAll("!!", "");
        Consecuencia=consecuencia;
    }
}
