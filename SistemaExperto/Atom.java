import java.util.Set;
import java.util.HashSet;

public class Atom{
	//Attributes
	private char char_;
	private String atom, atomAux;
	//private ArrayList<String> atoms = new ArrayList<String>();
	private Set<String> atoms = new HashSet<String>();
	private int nChars, nAtoms;
	private boolean flagEnd, flagAtom;
	//Builder
	public Atom(){
		atom = "";
		flagAtom = false;
		flagEnd = false;
	}
	//Methods
	public void setAtoms(String formula){
		nChars = formula.length();
		int i=0;
		for(i=0; i<nChars; i++){
			char_ = formula.charAt(i);
			if(Character.isUpperCase(char_))
				flagAtom = true;
			if(Character.isLetter(char_) || Character.isDigit(char_)){
				atom = atom+char_;
			}
			else{
				if(flagAtom == true)
					flagEnd = true;
			}
			if(flagEnd){
				atoms.add(atom);
				atom 		= "";
				flagEnd 	= false;
				flagAtom 	= false;
			}
		}
		atoms.add(atom);
	}
	public Set<String> getAtoms(){
		return atoms;
	}
}