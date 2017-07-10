import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/* Finding kth smallest elements in an unsorted array containing non-negative numbers */

/* Will be solving the problem using two approaches */

public class KthSmallestInUnSortedArray {
	
	private static void findByUsingHeap(int[] a, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);
		}	
		
		for (int i = 0; i < k-1; i++) {
		pq.poll();
	 }
		System.out.println(pq.poll());
	}
	
	private static int maximum(int[] a) {
		
		if(a.length == 0)
			return 0;
		
		int max = a[0];
		
		for(int i = 1; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		return max;		
	}

	private static int elementsLessThanMid(int[] a, int mid) {
		
		int c = 0;
		
		for (int i = 0; i < a.length; i++) {
			
			if(a[i] < mid)
				c++;			
		}
		
		return c;
	}
	
	private static int elementsGreaterThanOrEqualToMid(int[] a, int mid) {
		
		int ans = mid;
		for (int i = 0; i < a.length; i++) {
			
			if(a[i] < mid)
				continue;
			
			if(a[i] >= mid && ans > a[i]) {
				ans = a[i];
			}
		}
		return ans;
	}
	private static void findByUsingBinarySeach(int[] a, int k) {
		
		int lo = 0; 
		
		int hi = maximum(a);
		
		while(lo <= hi) {
			int mid = (lo + hi)/2;
			
			// count number of elements less than, equal or more than mid
			
			int num = elementsLessThanMid(a,mid);
			
			
			if(num < k-1) {
				lo = mid+1;
			}
			else if (num == k-1) {
						// find minimum element from an array which is greater than mid or equal to mid
				System.out.println(elementsGreaterThanOrEqualToMid(a,mid));
				break;
			}
			else {
				hi = mid-1;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int a[] = {8,7,2,10,11,6,3};   
		
		int b[] = a;
		
		Arrays.sort(b);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println("Enter k");
		
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		
		/* first approach -> creating a min Heap out of the array and then extracting min element k times
		 from the heap -> Approach will take O(n) space and O(n) + Klogn(n) time complexity */
		
		findByUsingHeap(a,k);
		
		/* Second approach is to use Binary search -> O(1) space and O(nlog(max)) time complexity
		 */
		
		findByUsingBinarySeach(a,k);
	}

}
