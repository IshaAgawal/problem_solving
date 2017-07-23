import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class NonRepeatingInCharacterStream {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		LinkedList<Character> q = new LinkedList<Character>();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		while (t > 0) {
			q.clear();    // clearing queue for next test case
			hm.clear();			// // clearing map for next test case
			int n = in.nextInt();

			while (n > 0) {

				char c = in.next().charAt(0);  // Scanning character

				if (hm.get(c) == null) {  // Adding it into the queue if the character is occuring for the first time
					q.add(c);
					hm.put(c, 1);
				} else  {  
					q.removeAll(Collections.singleton(c));  // enter the else block if element already occured in the past, clear all it's previous enteries
				}
				if (q.isEmpty()) {
					System.out.print(-1 + " ");
				} else {
					System.out.print(q.peek() + " ");
				}
				n--;
			}
			System.out.println();
			t--;
		}
	}
}
