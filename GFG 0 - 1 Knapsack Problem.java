// Recursion + Memoization
class Solution { 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) { 
        int dp[][] = new int[n][W + 1];
        for (int[] row: dp) Arrays.fill(row, -1);
        return rec(n - 1, W, wt, val, dp);
    } 
    
    static int rec(int item, int limit, int wt[], int val[], int[][] dp) {
        if (item == -1) return 0;
        if (dp[item][limit] != -1) return dp[item][limit];
        
        int notTake = rec(item - 1, limit, wt, val, dp);
        int take = 0;
        if (limit - wt[item] >= 0)
            take = val[item] + rec(item - 1, limit - wt[item], wt, val, dp);
        
        return dp[item][limit] = Math.max(take, notTake);
    }
}




// Tabulation:
class Solution {
    static int knapSack(int W, int wt[], int val[], int n) { 
        int dp[][] = new int[n + 1][W + 1];
        
        for (int item = 1; item <= n; item++)
            for (int limit = 1; limit <= W; limit++) {
                int notTake = dp[item - 1][limit];
                int take = 0;
                if (limit - wt[item - 1] >= 0)
                    take = val[item - 1] + dp[item - 1][limit - wt[item - 1]];
                
                dp[item][limit] = Math.max(take, notTake);
            }
        
        return dp[n][W];
    }
}

// Better:
class Solution {
    static int knapSack(int W, int wt[], int val[], int n) { 
        int dp[][] = new int[n + 1][W + 1];
        
        for (int item = 1; item <= n; item++)
            for (int limit = 1; limit <= W; limit++) {
                if (limit >= wt[item - 1])
                    dp[item][limit] = Math.max(dp[item - 1][limit], val[item - 1] + dp[item - 1][limit - wt[item - 1]]);
                else dp[item][limit] = dp[item - 1][limit];
            }
        
        return dp[n][W];
    }
}