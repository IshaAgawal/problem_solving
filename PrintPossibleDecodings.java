

public class PrintPossibleDecodings {

	static boolean valid(String str) {			// method to check if the integer value of given string is
									// between 1 & 26
		
		int k = Integer.parseInt(str);
		if (k > 0 && k <= 26)
			return true;

			return false;
	}

	static String convertToString(String s) {     // converting a number represented in string to a character it represents
		
		int k = 64 + Integer.parseInt(s);
		
		return String.valueOf((char)k);
	}


	static void decode(String str, String res) {

		if (str.length() == 0 ) {		// if reached the end
		System.out.println(res);    
		return;
		}
		
		
		if(str.length() == 1) {   // only 1 character is remaining to be process, can be processed here or can be processed with the below code
			System.out.println(convertToString(str.substring(0,1)) + res );
			return ;
		}			
		
		int n = str.length();

	if(valid(str.substring(n - 1, n))) {  // taking 1 character at a time
		 decode(str.substring(0, n - 1), convertToString(str.substring(n-1,n)) + res );  
	}
				
	if(valid(str.substring(n - 2, n))) {   // taking 2 character at a time
	
		 decode(str.substring(0, n - 2), convertToString(str.substring(n-2,n)) + res );	
	}
}

	public static void main(String[] args) {

		decode( "123","");  // Test case 1
		decode("12312","");  // Test case 2
	}
}
