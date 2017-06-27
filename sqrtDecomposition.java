package spoj;

import java.util.Scanner;

/*Problem statement -> Large number of queries needs to be performed in an array
 *  Following operations should be supported :
 *  a) build()    -> Build d blocks of d size ( d = sqrt(n) )  -> Takes o(n) time
 *  b) update()   -> Update the element in an array  -> O(1) time
 *  c) query()   -> find  sum of elements in a given range -> o(sqrt(n))
 *  
 * */
public class SqrtDecomposition {

	static int blocks[];
	static int block_size;

	private static void build(int[] a) {

		block_size = (int) Math.ceil(Math.sqrt(a.length));

		blocks = new int[block_size];

		for (int i = 0; i < a.length; i++) {

			blocks[i / block_size] += a[i];
		}
	}

	private static void update(int[] a, int index, int v) {

		int oldVal = a[index];

		blocks[index / block_size] += v - oldVal;

		a[index] = v;
	}

	private static void query(int[] a, int l, int r) {

		int leftBlock = l / block_size;

		int rightBlock = r / block_size;

		int sum = 0;

		for (int i = l; i < (leftBlock + 1) * block_size; i++) {
			sum += a[i];
		}

		for (int i = r; i >= rightBlock * block_size; i--) {
			sum += a[i];
		}

		for (int i = leftBlock + 1; i < rightBlock; i++) {
			sum += blocks[i];
		}

		System.out.println(sum);
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int a[] = new int[n];

		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}

		build(a);

		boolean flag = true;

		while (flag) {
			System.out
					.println("Press 1 for update, Press 2 for query, Press 3 for exit");

			int input = in.nextInt();

			switch (input) {
			case 1:
				System.out
						.println("Enter index and the value to which it needs to be updated");
				int index = in.nextInt();
				int v = in.nextInt();
				update(a, index, v);
				break;
			case 2:
				System.out.println("Enter left and right index");
				int l = in.nextInt();
				int r = in.nextInt();
				query(a, l, r);
				break;
			case 3:
				flag = false;
				break;
			default:
				break;
			}

		}
		in.close();
	}
}
