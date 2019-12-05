public class automata {
    
    String error = "", segment="";
    int estado = 0, cSegment=0, nSS = 0, nDS=0, nCS=0, sdoEstado=0;
    boolean bnBreak = false,bnSegment=false, ss = false, ds = false, cs = false, endCs=false;
    //boolean bnSegment=true;
    
    public boolean segment(String palabra, int nLinea){
        estado++;
        switch (estado){
            case 1:
                cSegment++;
                error ="";
                bnSegment=true;
                break;
            case 2:
                switch (palabra){
                    case "SS":
                        error = "";
                        ss = true;
                        segment = palabra;
                        bnSegment=true;
                        nSS = cSegment;
                        sdoEstado = 1;
                        break;
                    case "DS":
                        error = "";
                        ds = true;
                        segment = palabra;
                        bnSegment=true;
                        nDS = cSegment;
                        sdoEstado=2;
                        break;
                    case "CS":
                        error = "";
                        cs = true;
                        segment = palabra;
                        bnSegment=true;
                        nCS = cSegment;
                        sdoEstado=3;
                        break;
                    default:
                        estado = 0;
                        error = nLinea+"|No existe el segmento "+palabra;
                        bnSegment=false;
                }
                break;
            case 3:
                if(!(palabra.equals("END"))){
                    estado--;
                    //System.out.println(palabra);
                        if(palabra.equals("SEGMENT")){
                            //System.out.println(palabra);
                            error = nLinea-1+"|Falto cerrar el segment "+segment;
                            bnBreak = true;
                            bnSegment = false;
                            estado = 0;
                            sdoEstado=4;
                        }
                }else{
                    sdoEstado=0;
                    if(cs){
                        endCs=true;
                    }
                    error ="";
                }
                bnSegment=true;
                break;
            case 4:
                   if((palabra.equals(segment)))
                       error = "";
                   else{
                       error = nLinea+"|Te falto \""+segment+"\" despues del END";
                   }
                   bnSegment=false;
                   estado = 0;

                break;
            default:
               
           
        }
        
        return bnSegment;
    }
    
    public String getError(){
        return error;
    }
    public boolean getEndCs(){
        return endCs;
    }
    public boolean getSs(){
        return ss;
    }
    public boolean getDs(){
        return ds;
    }
    public boolean getCs(){
        return cs;
    }
    
    public int [] getnS(){
        int [] nS;
        nS = new int[3];
        nS[0] = nSS;
        nS[1] = nDS;
        nS[2] = nCS;
        return nS;
    }
    
    public int getSdoEstado(){
        return sdoEstado;
    }
    
    public boolean getBnBreak(){
        return bnBreak;
    }
}
