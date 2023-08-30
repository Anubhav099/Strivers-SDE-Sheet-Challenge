// using memoization (rec)
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        return dfs(n - 1, heights, dp);
    }
    static int dfs(int n, int[] heights, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] == 0) {
            int left = dfs(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
            int right = Integer.MAX_VALUE;
            if (n > 1) right = dfs(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
            dp[n] = Math.min(left, right);
        }
        return dp[n];
    }
}



// using tabulation
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(fs, ss);
        }
        return dp[n - 1];
    }
}



// Optimal TC: O(n), SC: O(1)
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int prev = 0, prev2 = 0;
        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) ss = prev2 + Math.abs(heights[i] - heights[i - 2]);

            prev2 = prev;
            prev = Math.min(fs, ss);
        }
        return prev;
    }
}