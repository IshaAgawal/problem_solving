
import java.util.PriorityQueue;

class SortKMessedArray {

	static int[] sortKMessedArray(int[] arr, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		int n = arr.length;

		for (int i = 0; i <= k; i++)
			pq.add(arr[i]);

		int result[] = new int[arr.length];

		result[0] = pq.poll();

		int index = 1;

		for (int i = k + 1; i < n ; i++) { // 1 4 5 3 2

			pq.add(arr[i]);

			result[index++] = pq.poll();
		}

		while (!pq.isEmpty()) { // remaining ele
			result[index++] = pq.poll();
		}
		return result;
	}

	public static void main(String[] args) {

		int result[] = sortKMessedArray(new int[] { 1, 4, 5, 2, 3, 7, 8, 6, 10, 9 }, 2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

}