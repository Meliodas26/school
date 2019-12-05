public class Zombie{
	//Atributes
	private int nFormula, nChar, typeChar;
	private String formula, mistake;
	private char char_, nextChar;
	//Flag is to know if there is a mistake on the formulas
	private boolean flag = false;
	//Builder
	public Zombie(){
		typeChar = 0;
		formula = "";
		mistake= "";
	}
	//Methods
	public boolean sleeping(String line, int nLine){
		formula = line;
		nFormula = nLine;
		nChar = formula.length();
		if(Character.isUpperCase(formula.charAt(0))){
			typeChar = 1;
			wake();
		}else{
			char_ = formula.charAt(0);
			switch (char_){
				case '(':
					typeChar = 2;
					wake();
					break;
				case '!':
					typeChar = 3;
					wake();
					break;
				default:
					if(Character.isDigit(char_) || Character.isLetter(char_))
						mistake = "Los atomos deben iniciar con una letra mayuscula";
					else	
						mistake = "La formula solo puede iniciar con:\nAtomo\n(\n!";
					printMistake(mistake);
					break;
			}
		}
		if(mistake.length()!=0)
			flag = true;
		return flag;
	}

	public void wake(){
		mistake="";
		for(int i=0; i<nChar; i++){
			if(i < nChar-1){
				char_ = formula.charAt(i+1);
				state02();
				//if(mistake.length) is to finish the code if a mistake is found
				if(mistake.length() == 0){
					nextChar = formula.charAt(i+1);
					typeChar = state01();
					if(!(mistake.length() == 0))
						i = nChar;
				}else
					i = nChar;
			}else{
				char_ = formula.charAt(i);
				sleep();
			}
		}
	}

	public int state01(){
		int option;
		if((Character.isLetter(char_) || Character.isDigit(char_))){
			option = 1;
		}else{
			switch (nextChar){
				case '(':
					option = 2;
					break;
				case '!':
					option = 3;
					break;
				case '&':
					option = 4;
					break;
				case '|':
					option = 5;
				break;
				case '<':
					option = 6;
				break;
				case '-':
					option = 7;
				break;
				case '>':
					option = 8;
				break;
				case ')':
					option = 9;
				break;
				default:
					option = 0;
					mistake = "Caracter no reconocido: "+char_;
					printMistake(mistake);
					break;
			}
		}
		return  option;
	}
	public void state02(){
		switch (typeChar){
			case 1:
				if(!(Character.isLetter(char_) || Character.isDigit(char_) || char_==')' || char_=='<' || 
					char_=='-' || char_=='&' || char_=='|')){
						if(char_ == '>' || char_ == '!')
							mistake = "Atomo"+char_;
						else
							mistake = "Caracter no reconocido: "+char_;
						printMistake(mistake);
					}
				break;
			case 2:
				if(!(Character.isUpperCase(char_) || char_=='!' || char_=='(')){
					mistake = "("+char_;
					if(Character.isLetter(char_) || Character.isDigit(char_))
						mistake = mistake+"\nUn atomo debe iniciar con mayuscula";
					printMistake(mistake);
				}
				break;
			case 3:
				if(!(Character.isUpperCase(char_) || char_=='(')){
					mistake = "!"+char_;
					if(Character.isLetter(char_) || Character.isDigit(char_))
						mistake = mistake+"\nUn atomo debe iniciar con mayuscula";
					printMistake(mistake);
				}
				break;
			case 4:
				if(!(Character.isUpperCase(char_) || char_=='!' || char_ == '(')){
					mistake = "&"+char_;
					if(Character.isLetter(char_) || Character.isDigit(char_))
						mistake = mistake+"\nUn atomo debe iniciar con mayuscula";
					printMistake(mistake);
				}
				break;
			case 5:
				if(!(Character.isUpperCase(char_) || char_=='!' || char_ == '(')){
					mistake = "|"+char_;
					if(Character.isLetter(char_) || Character.isDigit(char_))
						mistake = mistake+"\nUn atomo debe iniciar con mayuscula";
					printMistake(mistake);
				}
			break;
			case 6:
				if(char_ != '-'){
					mistake = "<"+char_;
					printMistake(mistake);
				}
			break;
			case 7:
				if(char_ != '>'){
					mistake = "-"+char_;
					printMistake(mistake);
				}
			break;
			case 8:
				if(!(Character.isUpperCase(char_) || char_=='!' || char_ == '(')){
					mistake = ">"+char_;
					printMistake(mistake);
				}
			break;
			case 9:
				if(!(char_ == '<' || char_ == '-' || char_ == '&' || char_ == '|' || char_ == ')')){
					mistake = ")"+char_;
					printMistake(mistake);
				}
			break;
			default:
				mistake= "Caracter no reconocido: "+char_;
				printMistake(mistake);
			break;
		}
	}

	public void sleep(){
		if(!(Character.isLetter(char_) || Character.isDigit(char_) || char_==')')){
			mistake = "La formula solo puede terminar con:\nAtomo\n)";
		}
	}

	public void printMistake(String mistake){
		System.out.println("-------------------------");
		System.out.println("Formula "+nFormula+" mal formada\n"+formula+"\n"+mistake);
	}
}