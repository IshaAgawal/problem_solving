
public class MaximumSumWithNoConsecutiveElements {

	public static void main(String[] args) {

		int arr[] = {8, 2, 3, 4};
		
		int dp[] = new int[arr.length];
		
		dp[0] = arr[0];
		
		dp[1] = Math.max(arr[1], dp[0]);
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
			
		}
		System.out.println(dp[dp.length-1]);
	}
}
