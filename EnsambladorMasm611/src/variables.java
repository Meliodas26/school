
import java.util.StringTokenizer;

public class variables {
    
    int estado = 0, tam = 0, sizeArray = 0, sizeEtiquetas;
    char [] letras;
    String errores="", variables="";
    String [][] array, arrayAnterior, etiquetas;
    boolean db = false, dw = false;
    
    public void automata(int nLinea, String linea){
        //estado++;
        
        String lineaAux = linea;
        StringTokenizer tokenPalabra;
        int tipo=0, c=0, comillas=0;
        String palabra ="", palabraAnt = "", sTipo ="", sVar = "", valor="", letra;
        
        if(estado >= 1){
            tokenPalabra = new StringTokenizer(linea, " ");
            while(tokenPalabra.hasMoreTokens()){
                if(c<2){
                    palabraAnt = palabra;
                    palabra = tokenPalabra.nextToken();
                }else
                    valor = tokenPalabra.nextToken();
                c++;
            }
            switch (c){
                case 1:
                    switch(palabra){
                        case "DB":
                            errores = errores+nLinea+"|Falta el nombre a la variable\n"; 
                            break;
                        case "DW":
                            errores = errores+nLinea+"|Falta el nombre a la variable\n"; 
                            break;
                        default:
                            errores = errores+nLinea+"|Falta el tipo de variable\n";
                    }
                    break;
                
                case 2:
                    pReservadas(palabraAnt, nLinea);
                    switch (palabra){
                        case "DB":
                            //comillas = linea.indexOf("\"");
                            break;
                        case "DW":
                            break;
                        default:
                            errores = errores+nLinea+"|No existe tipo de dato: \""+palabra+"\n";
                    }
                    letras = palabraAnt.toCharArray();
                    if(Character.isDigit(letras[0])){
                        errores = errores+nLinea+"|Una variable no puede iniciar con un numero";
                    }else{
                        tam = palabraAnt.length();
                        boolean error = false;
                        for(int i=1; i<tam; i++){
                            if (!(Character.isLetter(letras[i]))){
                                if(!(Character.isDigit(letras[i]))){
                                    errores = errores+nLinea+"|La variables no pueden contener caracteres especiales\n";
                                    error = true;
                                    break;
                                }
                            }
                        }
                        if(!error){
                            verificar(palabraAnt, palabra, nLinea, lineaAux);
                            error = false;
                        }
                        //variables = variables+palabraAnt+"|";
                    }
                    break;
                case 3:
                    pReservadas(palabraAnt, nLinea);
                    switch(palabra){
                        case "DB":
                            comillas = linea.indexOf("\"");
                            
                            switch(comillas){
                                case -1:
                                    errores = errores+nLinea+"|Falto cerrar la cadena en comillas: \"...\"\n";
                                    break;
                                default:
                                    linea = linea.replace(" ","");
                                    letras = linea.toCharArray();
                                    tam = linea.length();
                                    //comillas = 0;
                                    int i = 0;
                                    comillas = 0;
                                    for(i = 0; tam > i; i++){
                                        letra = Character.toString(letras[i]);
                                        if(letra.equals("\"")){
                                            comillas++;
                                        }
                                    }
                                    
                                    switch(comillas){
                                        case 1:
                                            errores = errores+nLinea+"Error de sintaxis: Falto una comilla\"...\"\n";
                                            break;
                                        case 2:
                                            
                                            tokenPalabra = new StringTokenizer(lineaAux, "\"");
                                            String antes = tokenPalabra.nextToken();
                                            
                                            StringTokenizer tAntes = new StringTokenizer(antes, " ");
                                            tAntes.nextToken();
                                            tAntes.nextToken();
                                            if(tAntes.hasMoreTokens()){
                                                errores = errores+nLinea+"|Errores de sintaxis: Verifique las comillas \"...\"\n";
                                            }else{
                                                if(tokenPalabra.hasMoreTokens()){
                                                    tokenPalabra.nextToken();
                                                    if(tokenPalabra.hasMoreTokens()){
                                                        String espacio = tokenPalabra.nextToken();
                                                        char [] letras = espacio.toCharArray();
                                                        int size = espacio.length();
                                                        boolean error = false;
                                                        for(int con = 0; con<size; con++){
                                                            espacio = Character.toString(letras[con]);
                                                            if(!espacio.equals(" ")){
                                                                errores = errores+nLinea+"|Error de sintaxis: Verifique las comillas \"...\"\n";
                                                                error = true;
                                                                break;
                                                            }
                                                        }
                                                        if(!error){
                                                            verificar(palabraAnt, palabra, nLinea, lineaAux);
                                                        }
                                                    }else{
                                                        verificar(palabraAnt, palabra, nLinea, lineaAux);
                                                    }
                                                }else{
                                                    errores = errores+nLinea+"Error de sintaxis: Si quiere dinicializar la variable en null, no le asigne valor inicial\n";
                                                }
                                            }
                                            break;
                                        default:
                                            errores = errores+nLinea+"Error de sintaxis: La cadena no puede contener comillas";
                                            break;
                                    }
                                    break;

                            }
                            break;
                            
                        case "DW":
                            boolean numerico;
                            int vo= 1;
                            if(isNumeric(valor)){
                                vo = Integer.parseInt(valor); 
                                if(!(vo > -65535 && vo <65535)){
                                    errores = errores+nLinea+"|Introduzca un valor entre -65535<X<65535\n";
                                }else{
                                    if(c>3){
                                        errores = errores+nLinea+"|DW solo acepta una expresion numerica";
                                    }else{
                                        verificar(palabraAnt, palabra, nLinea, lineaAux);
                                    }
                                }
                            }else{
                                if(c>2)
                                    errores = errores+nLinea+"|DW solo es para numeros, cambie el tipo a DB\n";
                            }
                            break;
                        default:
                            errores = errores+nLinea+"|No existe el tipo de dato: "+palabra+"\n";
                            
                    }
                    
                    letras = palabraAnt.toCharArray();
                    if(Character.isDigit(letras[0])){
                        errores = errores+nLinea+"|Una variable no puede iniciar con un numero";
                    }else{
                        tam = palabraAnt.length();
                        for(int i=1; i<tam; i++){
                            if (!(Character.isLetter(letras[i]))){
                                if(!(Character.isDigit(letras[i]))){
                                    errores = errores+nLinea+"|La variables no pueden contener caracteres especiales\n";
                                    break;
                                }
                            }   
                        }
                        variables = variables+palabraAnt+"|";
                    }
                break;
                default:
                    switch(palabra){
                        case "DW":
                            errores = errores+nLinea+"|Error sintantico: nombreVar + tipo + valorInicial(opcional)";
                        break;
                    
                        case "DB":
                        pReservadas(palabraAnt, nLinea);
                        comillas = linea.indexOf("\"");
                        switch(comillas){
                            case -1:
                                errores = errores+nLinea+"|Falto cerrar la cadena en comillas: \"...\"\n";
                                break;
                            default:
                                
                                linea = linea.replace(" ","");
                                letras = linea.toCharArray();
                                tam = linea.length();
                                //comillas = 0;
                                int i = 0;
                                comillas = 0;
                                for(i = 0; tam > i; i++){
                                    letra = Character.toString(letras[i]);
                                    if(letra.equals("\"")){
                                        comillas++;
                                    }
                                }
                        }
                        switch(comillas){
                            case 1:
                                errores = errores+nLinea+"Error de sintaxis: Falto una comilla\"...\"\n";
                                break;
                            case 2:
                                tokenPalabra = new StringTokenizer(lineaAux, "\"");
                                String antes = tokenPalabra.nextToken();

                                StringTokenizer tAntes = new StringTokenizer(antes, " ");
                                tAntes.nextToken();
                                tAntes.nextToken();
                                if(tAntes.hasMoreTokens()){
                                    errores = errores+nLinea+"|Errores de sintaxis: Verifique las comillas \"...\"\n";
                                }else{
                                    tokenPalabra.nextToken();
                                    if(tokenPalabra.hasMoreTokens()){
                                        System.out.println("Penultimo if");
                                        String espacio = tokenPalabra.nextToken();
                                        char [] letras = espacio.toCharArray();
                                        int size = espacio.length(); 
                                        boolean error = false;
                                        for(int con = 0; con<size; con++){
                                            espacio = Character.toString(letras[con]);
                                            if(!espacio.equals(" ")){
                                                errores = errores+nLinea+"|Error de sintaxis: Verifique las comillas \"...\"\n";
                                                error = true;
                                                break;
                                            }
                                        }
                                        if(!error){
                                            verificar(palabraAnt, palabra, nLinea, lineaAux);
                                        }
                                    }else{
                                        verificar(palabraAnt, palabra, nLinea, lineaAux);
                                    }
                                }
                                break;
                            default:
                                errores = errores+nLinea+"Error de sintaxis: La cadena no puede contener comillas";
                                break;
                        }
                    }
                //Break de default
            }
            c = 0;
            
        }
        estado++;
    }
    
    
    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
    
    public void ambiguedad(){
        StringTokenizer token = new StringTokenizer(variables, "|");
        int c=0, a=0, b =0;
        String [] variable;
        
        while(token.hasMoreTokens()){
            token.nextToken();
            c++;
        }
        variable = new String[c];
        c=0;
        StringTokenizer tokenAux = new StringTokenizer(variables, "|");
        while(tokenAux.hasMoreTokens()){
            variable[c] = tokenAux.nextToken();
            c++;
        }
        
        for(a=0; a<c; a++){
            for(b=a+1; b<c; b++)
            if(variable[a].equals(variable[b])){
                errores= errores+"Error de ambiguedad, la variable N:"+(a+1)+" es igual a la variable N:"+(b+1)+"\n";
            }
        }
    }
    
    
    public String getErrores(){
        return errores;
    }
    
    public void pReservadas(String palabraAnt, int nLinea){
        if( palabraAnt.equals("SEGMENT")    || palabraAnt.equals("SS")  || palabraAnt.equals("DS")  || palabraAnt.equals("CS")
                                || palabraAnt.equals("END")     || palabraAnt.equals("AX")  || palabraAnt.equals("AL")  || palabraAnt.equals("AH") 
                                || palabraAnt.equals("BX")      || palabraAnt.equals("BL")  || palabraAnt.equals("BH")  || palabraAnt.equals("CX")
                                || palabraAnt.equals("CL")      || palabraAnt.equals("CH")  || palabraAnt.equals("DX")  || palabraAnt.equals("DL")
                                || palabraAnt.equals("MOV")     || palabraAnt.equals("ADD") || palabraAnt.equals("SUB") || palabraAnt.equals("LOOP")
                                || palabraAnt.equals("JNZ")     || palabraAnt.equals("CMP") || palabraAnt.equals("INT") || palabraAnt.equals("OFFSET")
                                || palabraAnt.equals("DB")      || palabraAnt.equals("DW")  ){
                                errores = errores+nLinea+"|No puede usar este nombre \n";
                                if(palabraAnt.equals("SEGMENT")){
                                    errores = errores+"Segment no es valido, cambie este nombre y oprima de nuevo analizar \n";
                                }
                            }
    }
    
    public void verificar(String palabraAnt, String palabra, int nLinea, String linea){
        arrayAnterior = new String[sizeArray][3];
        int condicion = sizeArray;
        int x = 0;
        
        for(x=0; x<condicion; x++){
            arrayAnterior[x][0] = array[x][0];
            arrayAnterior[x][1] = array[x][1];
            arrayAnterior[x][2] = array[x][2];
        }
        
        sizeArray++;
        array = new String[sizeArray][3];
        
        boolean ambiguedad = false;
        condicion = sizeArray-1;
        for(x=0; x<condicion; x++){
            if(palabraAnt.equals(arrayAnterior[x][0])){
                ambiguedad = true;
                break;
            }else{
                array[x][0] = arrayAnterior[x][0];
                array[x][1] = arrayAnterior[x][1];
                array[x][2] = arrayAnterior[x][2];
            }
        }
        if(ambiguedad){
            errores = errores+nLinea+"|Error de ambiguedad: Ya existe una variable con ese nombre\n";
        }else{
            
            array[sizeArray-1][0] = palabraAnt;
            array[sizeArray-1][1] = palabra;
            StringTokenizer t = new StringTokenizer(linea,"");
            switch (palabra){
                case "DB":
                    t = new StringTokenizer(linea, "\"");
                    t.nextToken();
                    break;
                case "DW":
                    t = new StringTokenizer(linea, " ");
                    t.nextToken();
                    t.nextToken();
                    break;
            }
            if(t.hasMoreTokens()){
                array[sizeArray-1][2] = t.nextToken();
            }else{
                array[sizeArray-1][2] = "";
            }      
            
            for(int ciclo = 0; ciclo<sizeEtiquetas; ciclo++){
                if(array[sizeArray-1][0].equals(etiquetas[ciclo][0])){
                    errores = errores+nLinea+"|Error de ambiguedad: Este nombre ya esta siendo utilizada por la etiqueta en linea: "+etiquetas[ciclo][1]+"\n";
                    break;
                }
            }
        }
    }
    
    public void setEtiquetas(String [][] etiquetasMain, int sizeMain){
        etiquetas = etiquetasMain;
        sizeEtiquetas = sizeMain;
        
    }
    
    public String[][] getVariables(){
        return array;
    }
    public int getSizeArray(){
        return sizeArray;
    }
}
