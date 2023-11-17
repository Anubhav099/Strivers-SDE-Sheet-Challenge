// Memoization

import java.util.Arrays;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w + 1];
        for (int[] row: dp) Arrays.fill(row, -1);
        return rec(n - 1, w, profit, weight, dp);
    }
    static int rec(int ind, int w, int[] profit, int[] weight, int[][] dp) {
        if (ind == -1 || w == 0) return 0;
        if (dp[ind][w] != -1) return dp[ind][w];

        int notPick = rec(ind - 1, w, profit, weight, dp);
        int pick = 0;
        if (w >= weight[ind]) pick = profit[ind] + rec(ind, w - weight[ind], profit, weight, dp);

        return dp[ind][w] = Math.max(pick, notPick);
    }
}






// Tabulation
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n + 1][w + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int we = 1; we <= w; we++) {
                int notPick = dp[i - 1][we];
                int pick = 0;
                if (we >= weight[i - 1]) pick = profit[i - 1] + dp[i][we - weight[i - 1]];

                dp[i][we] = Math.max(pick, notPick);
            }
        }
        return dp[n][w];
    }
}





// Space optimization
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n + 1][w + 1];
        int[] prev = new int[w + 1];
        
        for (int i = 1; i <= n; i++) {
            int[] cur = new int[w + 1];
            for (int we = 1; we <= w; we++) {
                int notPick = prev[we];
                int pick = 0;
                if (we >= weight[i - 1]) pick = profit[i - 1] + cur[we - weight[i - 1]];

                cur[we] = Math.max(pick, notPick);
            }
            prev = cur;
        }
        return prev[w];
    }
}