import java.util.StringTokenizer;

public class pReservadas {
    //Tipo de operador 1
    boolean bn1 = false, bn2 = false;
    String tipo1="", tipo2="", op1 = "", op2 = "";
    String [][] variables;
    
    boolean salto = false, comas = false;
    StringTokenizer token;
    StringTokenizer tokenAux;
    
    String pR, palabra, errores ="", antes;
    int estado = 0, sizeVar = 0;
    etiquetas etiqueta = new etiquetas();
    
    public void automata(String linea, int nLinea){
        
        if(estado>0){
            token = new StringTokenizer(linea, " ");
            pR = token.nextToken();
            switch(pR){
                case "MOV":
                    if(linea.contains("OFFSET")){
                        StringTokenizer tComa = new StringTokenizer(linea, ",");
                        tComa.nextToken();
                        if(tComa.hasMoreTokens()){
                            String despues = tComa.nextToken();
                            StringTokenizer tEspacio = new StringTokenizer(despues, " ");
                            String palabra = tEspacio.nextToken();
                            
                            if(palabra.equals("OFFSET")){
                                String lineaOffset = linea.replace(",", " ");
                                tEspacio = new StringTokenizer(lineaOffset, " ");
                                int espacios = 0;
                                while(tEspacio.hasMoreTokens()){
                                    tEspacio.nextToken();
                                    espacios++;
                                }
                                if(espacios==4){
                                    lineaOffset = linea.replace("OFFSET", "");
                                    operadores(lineaOffset, nLinea);
                                }else{
                                    errores = errores+nLinea+"|Error sintantico: MOV + Operador1 + , + OFFSET +Operador 2\n";
                                }
                            }else{
                                errores = errores+nLinea+"|Error sintantico: MOV + Operador1 + , + OFFSET +Operador 2\n";
                            }
                        }else{
                            errores = errores+nLinea+"|Error sintantico: MOV + Operador1 + , + OFFSET +Operador 2\n";
                        }
                    }else{
                        operadores(linea, nLinea);
                    }
                    break;
                case "ADD":
                    operadores(linea, nLinea);
                    if(op1.equals("AX") || op1.equals("AH") || op1.equals("AL")){
                        //Todo en orden
                    }else{
                        errores = errores+nLinea+"|Error de sintaxis: El 1er Operador debe se: AX, AH O AL\n";
                    }
                    break;
                case "SUB":
                    operadores(linea, nLinea);
                    if(op1.equals("AX") || op1.equals("AH") || op1.equals("AL")){
                        //Todo en orden
                    }else{
                        errores = errores+nLinea+"|Error de sintaxis: El 1er Operador debe se: AX, AH O AL\n";
                    }
                    break;
                    
                case "CMP":
                    operadores(linea, nLinea);
                    break;
                    
                case "LOOP":
                    salto = true;
                    if(token.hasMoreTokens()){
                        palabra = token.nextToken();
                        if(palabra.equals("CMP")){
                            String lineaLoop = linea.replace("LOOP", "");
                            operadores(lineaLoop, nLinea);
                        }else{
                            errores = errores+nLinea+"|Error de sintaxis: despues de loop va: \"CMP\"\n";
                        }
                    }else{
                        errores = errores+nLinea+"|Error de sintaxis: LOOP + CMP + op1 + , + op2\n";
                    }
                    break;
                case "INT":
                    if(token.hasMoreTokens()){
                        palabra = token.nextToken();
                            System.out.println(palabra);
                            if(palabra.equals("02H") || palabra.equals("09H") ||  palabra.equals("21H")){
                                if(token.hasMoreTokens())
                                    errores = errores+nLinea+"|Error sintactico: INT TIPO\n";
                            }else
                                errores = errores + nLinea+"|No existe ese tipo de interupcion\n";
                    }else
                        errores = errores+nLinea+"|Te hace falta el tipo de interrupcion\n";
                    break;
                default:
                    if(token.hasMoreTokens()){
                        boolean bnWhile = true;
                        while(bnWhile){
                            palabra = token.nextToken();
                            switch(palabra){
                                case "MOV":
                                    errores = errores+nLinea+"|MOV va al inicio\n";
                                    bnWhile = false;
                                    break;
                                case "INT":
                                    errores = errores+nLinea+"|INT va al inicio\n";
                                    bnWhile = false;
                                    break;
                                case "ADD":
                                    errores = errores+nLinea+"|ADD va al inicio\n";
                                    bnWhile = false;
                                    break;
                                case "SUB":
                                    errores = errores+nLinea+"|SUB va al inicio\n";
                                    bnWhile = false;
                                    break;
                                case "OFFSET":
                                    errores = errores+nLinea+"|Falta MOV al inicio\n";
                                    bnWhile = false;
                                    break;
                                case "LOOP":
                                    errores = errores+nLinea+"|LOOP va al inicio\n";
                                    bnWhile = false;
                                    break;
                                case "CMP":
                                    errores = errores+nLinea+"|CMP va al inicio\n";
                                    bnWhile = false;
                                    break;
                                case "JNZ":
                                    errores = errores+nLinea+"|JNZ va al inicio\n";
                                    bnWhile = false;
                                    break;
                                default:
                                    if(!token.hasMoreTokens()){
                                        errores = errores+nLinea+"|Instruccion invalida\n";
                                        bnWhile = false;
                                    }
                            }
                        }
                    }else{
                        errores = errores+nLinea+"|Instruccion invalida\n";
                    }
            }
            if(comas){
                
            }
        }
        estado++;
    }
    
    public void jnz(String linea, int nLinea, String[][] array, int size){
        token = new StringTokenizer(linea, " ");
        palabra = token.nextToken();
        if(token.hasMoreTokens()){
            palabra = token.nextToken();
            boolean res = false;
            for (int y=0; y<size; y++){
                if(array[y][0].equals(palabra)){
                    res = true;
                    break;
                }
            }
            if(!res)
                errores = errores+nLinea+"|Error de ambiguedad: No existe esa etiqueta\n";
        }else
            errores = errores+nLinea+"|Falta etiqueta despues de \"JNZ\"\n";
    }
    
    //Metodos para verificar los registros
    public void operadores(String linea, int nLinea){
        if(linea.contains(",")){
            char [] comas = linea.toCharArray();
            int cComas=0;
            for(int con=0; con<linea.length(); con++){
                if(Character.toString(comas[con]).equals(",")){
                    cComas++;
                }
            }
            if(cComas==1){
                
            
            String palabra;
            op1 = "";
            op2 = "";
            
            StringTokenizer t = new StringTokenizer(linea, ",");
            palabra = t.nextToken();
            StringTokenizer tE = new StringTokenizer(palabra, " ");
            tE.nextToken();
            if(tE.hasMoreTokens()){
                op1 = tE.nextToken();
                //1er operador
                bn1 = false;
                tipo1 = "";
                tipoOp1(op1);
                if(t.hasMoreTokens()){
                    palabra = t.nextToken();
                    //Verificas 2dgo operador
                    bn2 = false;
                    tipo2 = "";
                    tE = new StringTokenizer(palabra, " ");
                    op2 = tE.nextToken();
                    tipoOp2(op2);
                    if(!tE.hasMoreTokens()){
                        if(!t.hasMoreTokens()){
                            //Verificar que op1 si pueda ser usado por la palabra reservada
                            if(bn1){
                                if(bn2){
                                    if(tipo1.equals(tipo2)){
                                       //Todo salio bien 
                                    }else{
                                        errores = errores+nLinea+"|Error de ambiguedad: Los operadores son de diferente tipo\n";
                                    }
                                }else{
                                    errores = errores+nLinea+"|Error en el 2do operador\n";
                                }
                            }else{
                                errores = errores+nLinea+"|Error en el 1er operador\n";
                            }
                        }else{
                            errores = errores+nLinea+"|Error de sintaxis: PReservada + operador1 + , + operador 2\n";
                        }
                    }else{
                        errores = errores+nLinea+"|Error de sintaxis: PReservada + operador1 + , + operador 2\n";
                    }
                }else{
                    errores = errores+nLinea+"|Error de sintaxis: PReservada + operador1 + , + operador 2\n";
                }
            }else{
                errores = errores+nLinea+"|Error de sintaxis: PReservada + operador1 + , + operador 2\n";
            }
            
            }else{
                errores = errores+nLinea+"|Error de sintaxis: PReservada + operador1 + , + operador 2\n";
                errores = errores+"Si es MOV con OFFSET: PReservada + operador1 + , + OFFSET + operador 2\n";
            }
        }else{
            errores = errores+nLinea+"|Error de sintaxis: PReservada + operador1 + , + operador 2\n";
        }
    }
    
    public void tipoOp1(String op1){
        if(op1.equals("AX") || op1.equals("AH") || op1.equals("AL") || op1.equals("AX") || 
        op1.equals("BX") || op1.equals("BH") || op1.equals("BL")){
            tipo1 = "DW";
            bn1 = true;
        }else{
            if(op1.equals("DX") || op1.equals("DH") || op1.equals("DL")){
            tipo1 = "DB";
            bn1 = true;
            }else{
                boolean error = true;
                for(int ciclo = 0; ciclo < sizeVar; ciclo++){
                    if(op1.equals(variables[ciclo][0])){
                        tipo1 = variables[ciclo][1];
                        bn1 = true;
                        error = false;
                        break;
                    }
                }
                if(error){
                    errores = errores + "Error de ambiguedad en op1: No existe esa variable\n";
                }
            }
        }
    }
    
    public void tipoOp2(String op2){
        if(op2.equals("AX") || op2.equals("AH") || op2.equals("AL") || op2.equals("AX") || 
           op2.equals("BX") || op2.equals("BH") || op2.equals("BL")){
            tipo2 = "DW";
            bn2 = true;
        }else{
            if(op2.equals("DX") || op2.equals("DH") || op2.equals("DL")){
            tipo2 = "DB";
            bn2 = true;
            }else{
                boolean error = true;
                for(int ciclo = 0; ciclo < sizeVar; ciclo++){
                    if(op2.equals(variables[ciclo][0])){
                        tipo2 = variables[ciclo][1];
                        bn2 = true;
                        error = false;
                        break;
                    }
                }
                if(!bn2){
                    boolean num = isNumeric(op2);
                    if(num){
                        tipo2 = "DW";
                        bn2 = true;
                    }else{
                        char [] letras = op2.toCharArray();
                        String letra;
                        int caso = (op2.length())-1;
                        boolean PComilla = false, SComilla = false, caracter =false;
                        for(int i=0; i<op2.length(); i++){
                            letra = Character.toString(letras[i]);
                            switch(i){
                                case 0:
                                    if(letra.equals("'")){
                                        PComilla = true;
                                    }
                                    break;
                                default:
                                    if(i == caso){
                                        if(letra.equals("'")){
                                            SComilla = true;
                                        }
                                    }else{
                                        if(letra.equals("\"")){
                                            i = op2.length();
                                        }
                                    }
                            }

                        }
                        if( PComilla && SComilla){
                            tipo2 = "DB";
                            bn2 = true;
                            error = false;
                        }
                        if(error){
                            errores = errores + "Error de ambiguedad en op2: No existe esa variable\nNota:Si es un caracter o una palabra: ' + palabra + '\n";
                        }
                    }
                }
            }
        }
    }
    
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    
    public void setSalto(boolean s){
        salto = s;
    }
    public boolean  getSalto(){
        return salto;
    }
    
    public String getErrores(){
        return errores;
    }
    
    public void setVariables(String [][] var){
        variables = var;
    }
    
    public void setSizeVariables(int sVar){
        sizeVar = sVar;
    }
}
