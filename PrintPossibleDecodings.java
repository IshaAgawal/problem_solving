package manish;

public class PrintPossibleDecodings {

	static boolean valid(String str) {
		
		int k = Integer.parseInt(str);
		if (k > 0 && k <= 26)
			return true;

		else
			return false;
	}

	static String convertToString(String s) {
		
		int k = 64 + Integer.parseInt(s);
		
		return String.valueOf((char)k);
	}
	static void decode(String str, String res) {

		if (str.length() == 0 ) {
		System.out.println(res);
		return ;
		}
		
		
		if(str.length() == 1) {
			System.out.println(convertToString(str.substring(0,1)) + res );
			return ;
		}			
		
		int n = str.length();

	if(valid(str.substring(n - 1, n))) {
		 decode(str.substring(0, n - 1), convertToString(str.substring(n-1,n)) + res );
	}
				
	if(valid(str.substring(n - 2, n))) {
	
		 decode(str.substring(0, n - 2), convertToString(str.substring(n-2,n)) + res );	
	}
}

	public static void main(String[] args) {

		decode( "123","");  // Test case 1
		decode("12312","");  // Test case 2
	}
}
