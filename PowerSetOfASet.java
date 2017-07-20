package manish;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class PowerSetOfASet {
	static Scanner in;

	static void printVector(Vector<Integer> v) {

		Iterator<Integer> itr = v.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();

	}

	private static void findPowerSets(int[] a, int index, int n,
			Vector<Integer> v) {

		if (!v.isEmpty())
			printVector(v);

		if (index >= n)
			return;

		v.add(a[index]);
		findPowerSets(a, index + 1, n, v);
		v.remove(v.size() - 1);
		findPowerSets(a, index + 1, n, v);

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
		Vector<Integer> v = new Vector<Integer>();
		findPowerSets(a, 0, n, v);
	}
}
