package pramp;

public class DecryptMessage {

	public static void decrypt(String word) {

		int l = word.length();

		int a[] = new int[l];

		for (int i = 0; i < a.length; i++) {

			a[i] = word.charAt(i);
		}

		int k, c;

		int toSubtract = 1;

		for (int i = 0; i < a.length; i++) {

			k = a[i] - toSubtract;
			c = (122 - k) / 26;
			k += c * 26;
			System.out.print((char) (k));
			toSubtract = a[i];
		}
	}

	public static void main(String[] args) {

		decrypt("dnotq");
		System.out.println();
		decrypt("flgxswdliefy");

	}
}
