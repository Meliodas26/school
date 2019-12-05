import java.util.StringTokenizer;

public class etiquetas {
    String errores = "", etiquetasT="", nLineasT="";
    boolean bandera = false;
    String [][] etiquetas;
    int size;
    
    public void automata(int nLinea, String linea){
        String etiqueta = "";
        StringTokenizer token;
        int c=0, i = 0;
        char [] letras;
        if(bandera){
            token = new StringTokenizer(linea, " ");
            while(token.hasMoreTokens()){
                etiqueta = token.nextToken();
                c++;
            }
            if(c!=1){
                errores = errores+nLinea+"|Las etiquetas solo pueden ser una palabra\n";
            }else{
                pReservadas(etiqueta, nLinea);
                if(errores.equals("")){
                    etiquetasT = etiquetasT+etiqueta+"|";
                    nLineasT = nLineasT+nLinea+"|";
                    token = new StringTokenizer(etiquetasT, "|");
                    i=0;
                    while(token.hasMoreTokens()){
                        token.nextToken();
                        i++;
                    }
                    size = i;
                    etiquetas = new String[i][2];
                    token = new StringTokenizer(etiquetasT, "|");
                    i=0;
                    for(i=0; i<size-1; i++){
                        etiquetas[i][0] = token.nextToken();
                        String numero = Integer.toString(nLinea);
                        etiquetas[i][1] = numero;
                            if(etiquetas[i][0].equals(etiqueta))
                                errores = errores+nLinea+"|Error de ambiguedad, ya existe una etiqueta con este nombre\n"; 
                    }
                    setEtiquetas();
                    
                    letras=etiqueta.toCharArray();
                    if(Character.isDigit(letras[0])){
                        errores = errores+nLinea+"|Una etiqueta no puede iniciar con un numero";
                    }else{
                        int tam = etiqueta.length();
                        for(int a=1; a<tam; a++){
                            if (!(Character.isLetter(letras[a]))){
                                if(!(Character.isDigit(letras[a]))){
                                errores = errores+nLinea+"|Una etiqueta no puede contener caracteres especiales\n";
                                break;
                                }
                            }   
                        }
                    }
                }
            }
        }
        bandera = true;
    }
    
    public void pReservadas(String palabra, int nLinea){
        if( palabra.equals("SEGMENT")   || palabra.equals("SS")  || palabra.equals("DS")  || palabra.equals("CS")
            || palabra.equals("END")    || palabra.equals("AX")  || palabra.equals("AL")  || palabra.equals("AH") 
            || palabra.equals("BX")     || palabra.equals("BL")  || palabra.equals("BH")  || palabra.equals("CX")
            || palabra.equals("CL")     || palabra.equals("CH")  || palabra.equals("DX")  || palabra.equals("DL")
            || palabra.equals("MOV")    || palabra.equals("ADD") || palabra.equals("SUB") || palabra.equals("LOOP")
            || palabra.equals("JNZ")    || palabra.equals("CMP") || palabra.equals("INT") || palabra.equals("OFFSET")
            || palabra.equals("DB")     || palabra.equals("DW")  ){
            
                errores = errores+nLinea+"|No puede usar este nombre \n";
                
                if(palabra.equals("SEGMENT")){
                    errores = errores+"No puede usar segment como nombre, cambie este nombre y oprima de nuevo analizar \n";
                }
        }
    }
    
    public void setEtiquetas(){
        etiquetas = new String [size+1][2];
        StringTokenizer token = new StringTokenizer(etiquetasT,"|");
        StringTokenizer t = new StringTokenizer(nLineasT,"|");
        for(int c = 0; c < size; c++){
            //if(token.hasMoreTokens());
            etiquetas[c][0] = token.nextToken();
            etiquetas[c][1] = t.nextToken();
        }   
    }
    
    public String[][] getEtiquetas(){
        return etiquetas;
    }
    public int getSize(){
        return size;
    }
    
    public String getErrores(){
        return errores;
    }
    
}
