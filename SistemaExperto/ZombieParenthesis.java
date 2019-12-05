public class ZombieParenthesis{
	private String formula;
	private char char_;
	private int nFormula;
	private boolean mistake;
	public ZombieParenthesis(){
		formula = "";
		nFormula = 0 ;
		mistake = false;
	}
	public boolean sleeping(String formula, int nFormula){
		int nChar, control = 0;
		nChar = formula.length();
		int i;
		for(i=0; i<nChar; i++){
			char_ = formula.charAt(i);		
			switch (char_){
				case '(':
					control++;
				break;
				case ')':
					if(!(control>=0)){
						System.out.println("Formula "+nFormula+" mal formada\n"+formula+"\nVerifique los '()'");
						mistake = true;
						i = nChar;
					}
					control--;
				break;
			}
		}
		if(control != 0){
			mistake = true;
			System.out.println("Formula "+nFormula+" mal formada\n"+formula+"\nVerifique los '()'");
		}
		return mistake;
	}
}