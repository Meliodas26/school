import java.util.StringTokenizer;

public class Diccionario{
	private String [][] hecho;
	private String text, linea;
	private int nHecho;

	public Diccionario(String [][] hecho, String text, int nHecho){
		this.text = text;
		this.hecho = hecho;
		this.nHecho = nHecho;
		setHecho();
	}

	public void setHecho(){
		Line line = new Line(text, nHecho);
		for (int i=0; i<nHecho; i++) {
			linea = line.getLine(i);
			linea = linea.replace("\t", "");
			linea = linea.replace(" ", "");
			StringTokenizer token = new StringTokenizer(linea, ":");
			hecho[i][0] = token.nextToken();
			hecho[i][1] = token.nextToken();
	    }
	}

	public String[][] getHecho(){
		return hecho;
	}
}