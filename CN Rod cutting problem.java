// memoization
import java.util.Arrays;
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return rec(n, price, dp);
	}
	static int rec(int w, int[] price, int[] dp) {
		if (w == 0) return 0;
		if (dp[w] != -1) return dp[w];
		int mx = 0;
		for (int i = 0; i < price.length; i++) {
			if (w >= i + 1)
				mx = Math.max(mx, price[i] + rec(w - (i + 1), price, dp));
		}
		return dp[w] = mx;
	}
}



// tabulation
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[] dp = new int[n + 1];
		
		for (int w = 1; w <= n; w++) {
			int mx = 0;
			for (int i = 0; i < price.length; i++) {
				if (w >= i + 1)
					mx = Math.max(mx, price[i] + dp[w - (i + 1)]);
			}
			dp[w] = mx;
		}

		return dp[n];
	}
}