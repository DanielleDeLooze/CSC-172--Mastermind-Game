

public class MasterMind {
	
	public String[][] list;
	private int positions;
	private int total;
	private int numColors;
	private String[] tokenColors;
	protected String[] guess;
	private String[] tester;
	
	public MasterMind(String[] tokenColors, int positions){
		int start = 1;
		this.positions = positions;
		
		this.numColors = tokenColors.length;
		this.total = (int)Math.pow(numColors, this.positions);
		this.list = new String[total][positions];
		this.tokenColors = tokenColors;
		
		for(int i =0; i < (numColors); i++){
			startArray(numColors, total, tokenColors[i], start-1);
			start += (total/numColors);
			
		}
		
		fillArray(total/numColors/numColors, 0, 1, 0);
		
		
	}
	
	public  void startArray(int numColors, int total, String color, int start){
		for(int i =0; i <(total/numColors); i++){
			list[start][0] = color;
			start++;
		}
		
	}
	
	public void fillArray(int n, int listIndex, int position, int token){
		if(position < positions){
			if(listIndex < total){
				if(token == numColors){
					token = 0;
				}
				for(int i = 0; i<n; i++){
					list[listIndex][position] = tokenColors[token];
					listIndex++;
				}
				fillArray(n, listIndex, position, token+1 );
				
			}
			fillArray(n/numColors, 0, position+1,0);
		}
	}
	
	
	
	public void response(int colorsRight, int colorsMixed){
		String[] placeHolder = guess.clone();
		for(int i =0; i<total;i++){
			int testRight = 0;
			int testMixed = 0;
			
			if(!(list[i] == null)){
				tester = list[i].clone();
				
				for(int j = 0; j<positions;j++){
					String tempString = placeHolder[j];
					if(tempString.equals(tester[j])){
						testRight++;
						
						tester[j] = null;
					}
				}
				
				for(int k = 0; k<positions; k++){
					if (!(tester[k] == null) ){
						for(int y=0; y<positions; y++){
							if(!(tester[k] == null)){
								String tempStringk = placeHolder[k];
								if(tempStringk.equals(tester[y])){
									testMixed++;
								}
							}
						}
					}
				}
				
				
				if(testRight !=colorsRight || testMixed!=colorsMixed){
					list[i]=null;
				}
			}
			
		}
		
	}
	
	public void newGame(){
		this.list = null;
		this.numColors = 0;
		this.tester = null;
		this.tokenColors = null;
		this.total = 0;
		this.guess = null;
		this.positions = 0;
	}
	
	public void nextMove(){
		for(int i = 0; i<total; i++){
			if(list[i]!=null){
				this.guess = list[i].clone();
				break;
			}
			
			
		}
	}
	
}	
		
	
	