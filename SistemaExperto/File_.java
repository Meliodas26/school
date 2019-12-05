//package SE;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class File_{
	//Attributes
	private String text;
	private int nLines;
	private boolean mistake = false;

	//Builder
	public File_(){
		this.text = "";
		this.nLines = 0;
	}

	//Methods
	public boolean setText(String route){
		String line;
			try{
				System.out.println(route);
				File f = new File (route+".txt");
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);

				while((line = br.readLine()) != null){
					this.text = this.text+line+"\n";
					setNLines();
				}
				fr.close();
				mistake = false;
			}catch(Exception e){
				System.out.println("Archivo no encontrado");
				mistake = true;
			}
		return mistake;
	}

	public void setNLines(){
		this.nLines++;
	}

	public String getText(){
		return this.text;
	}
	public int getNLines(){
		return nLines;
	}
}