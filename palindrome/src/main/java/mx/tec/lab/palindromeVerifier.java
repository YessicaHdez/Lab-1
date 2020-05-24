package mx.tec.lab;

public class palindromeVerifier {
 public static boolean verify (String input){
	 String inputAux = input.replaceAll("\\s","");
	 StringBuilder builder = new StringBuilder(); 
	 for(int i = input.length(); i >= 0; i--) {
		 builder.append(inputAux.charAt(i));
		 
	 }
	 return builder.toString().equals(inputAux);
	 
	
 }
}
