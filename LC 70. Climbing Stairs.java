class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return dfs(n, dp);
    }
    int dfs(int cur, int[] dp) {
        if (cur == 0 || cur == 1) return 1;
        if (dp[cur] == 0)
            dp[cur] = dfs(cur - 1, dp) + dfs(cur - 2, dp);
        return dp[cur];
    }
}
// TC: O(n), SC: O(n + n)
// This is called Memoization in dp. That you remember the ans to an already solved sub-problem. This avoid re-computation of overlapping sub-problems.



// Approach - 2: iterative: no recurive stack space
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i < n + 1; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}
// TC: O(n), SC: O(n)
// This is called tabulation in dp.


// Approach - 3 Space optimized approach
class Solution {
    public int climbStairs(int n) {
        int prev = 1, prev2 = 1, cur = 0;

        for (int i = 2; i <=n; i++) {
            cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
// TC: O(n), SC: O(1)
// This is space optimized version of tabulation of dp, where we made a small observation that to find the nth fibonaaci number, we only need n-1 and n-2 numbers. We don't need to store everything in the array.