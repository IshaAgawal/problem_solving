import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class LargestInWindow {
	
	static class Pair {   // Inner static class
		
		int a;
		int b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	private static Scanner s;

	public static void main(String args[]) {
		
		s = new Scanner(System.in);
		int i;
		int n = s.nextInt();    // Input n
		int a[] = new int[n];
		
		for( i=0; i<n; i++) {
			a[i] = s.nextInt();
		}
			int k = s.nextInt();   // Input k
			Deque<Pair> d = new  LinkedList<Pair>();   // In my deque I want to store a[i] and i that's why Pair
			int index =0;
			
			i =0;
			
			while( i < n && i < k) {
				
				if(d.isEmpty()){
					d.add(new LargestInWindow.Pair(a[i],i));  // creating instance of Pair and adding it to d
				}
				
				else {
					
					while(!d.isEmpty() && d.peekFirst().b < index)
						d.pollFirst();
					
					while(!d.isEmpty() && d.peekLast().a < a[i])
						d.pollLast();
					
					d.add(new Pair(a[i],i));
				}
				
				i++;
				if(i == k)
				{  k++;
					index++;
					System.out.println(d.peekFirst().a); // Everytime the front of the queue is maximum
				}
			}
	}
}