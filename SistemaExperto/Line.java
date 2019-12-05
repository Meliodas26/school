import java.util.StringTokenizer;

public class Line{
	//Attributes
	private String [] line;
	private String text;
	//Builder
	public Line(String text, int nLines){
		this.text = text;
		this.line = new String [nLines];
		setLine(nLines);
	}
	//Methods
	public void setLine(int nLines){
		StringTokenizer token = new StringTokenizer(text, "\n");
		int i=0;
		while (token.hasMoreTokens()){
			line[i] = token.nextToken();
			i++;
		}
	}
	public String getLine(int nLine){
		return line[nLine];
	}
}