package geeksfor.geeks.strings;

public class FirstNonRepeatingCharacters {

	public static void main(String[] args) {
		String str = "GeeksQuiz";
		
		for (int i = 0; i < str.length(); i++) {
			int j=1;
			while(j < str.length() && str.charAt(i)!=str.charAt(j)){
				
				j++;
			}
			/*for (int j = i+1; j < str.length()-1; j++) {
				if(str.charAt(i)==str.charAt(j)){
					
				}
			}*/
		}
	}
	
}
