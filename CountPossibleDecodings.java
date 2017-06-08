package manish;

public class CountPossibleDecodings {

	static boolean valid(String str) {
		
		int k = Integer.parseInt(str);
		if (k > 0 && k <= 26)
			return true;

		else
			return false;
	}

	static int decode(String str) {

		if (str.length() == 0 || str.length() == 1)
			return 1;
		int n = str.length();

		return (valid(str.substring(n - 1, n)) ? decode(str.substring(0, n - 1))
				: 0)
				+ (valid(str.substring(n - 2, n)) ? decode(str.substring(0,
						n - 2)) : 0);

	}

	public static void main(String[] args) {

		String str = "12321";  // testing the code

		System.out.println(decode(str));
	}
}
