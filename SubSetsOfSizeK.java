import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class SubSetsOfSizeK {

	static Vector<Vector<Integer>> r = new Vector<Vector<Integer>>();
	private static Scanner in;

	static void findSubSets(Vector<Integer> v, int a[], int index, int n, int k) {

		if (k <= 0) {
			Vector<Integer> v1 = new Vector<Integer>(v);
			r.add(v1);
			return;
		}

		if (k > n || index >= n) {
			return;
		}

		v.add(a[index]);
		findSubSets(v, a, index + 1, n, k - 1);
		v.remove(v.size() - 1); // removing the last element
		findSubSets(v, a, index + 1, n, k);

	}

	public static void main(String[] args) {
		
		in = new Scanner(System.in);

		System.out.println("Enter n");
		int n = in.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements in a set");
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		System.out.println("Enter k");

		int k = in.nextInt();
		Vector<Integer> v = new Vector<Integer>();

		findSubSets(v, a, 0, n, k);

		Iterator<Vector<Integer>> itr = r.iterator();

		while (itr.hasNext()) {

			Vector<Integer> buffVec = itr.next();
			Iterator<Integer> itr2 = buffVec.iterator();

			while (itr2.hasNext()) {

				System.out.print(itr2.next().intValue() + " ");
			}
			System.out.println();
		}
	}
}
