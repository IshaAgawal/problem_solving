package manish;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class IterationSubSetFinding {
	static Scanner in;
	static int totalSets = 0;
	static void printVector(Vector<Integer> v) {

		Iterator<Integer> itr = v.iterator();

		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
	}

	static void findSet(int a[], int i, int n, int k) {
		Vector<Integer> v = new Vector<Integer>();
		int count = 0, index = 0;

		while (i > 0) {

			if (i % 2 != 0) {
				count++;
				v.add(a[index]);
			}
			i = i / 2;
			index++;
		}

		if (count == k) {
			printVector(v);
			totalSets++;
		}

	}

	static void findSubSets(int a[], int n, int k) {

		for (int i = 1; i < Math.pow(2, n); i++) {
			findSet(a, i, n, k);
		}
		System.out.println("Total sets formed are " + totalSets);
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
		findSubSets(a, n, k);
	}
}
