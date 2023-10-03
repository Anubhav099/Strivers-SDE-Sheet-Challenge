public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] memo = new int[n][k + 1];
        return help(n - 1, k, arr, memo);
    }
    private static boolean help(int n, int k, int[] arr, int[][] memo) {
        if (k == 0) return true;
        if (n < 0 || k < 0) return false;
        if (memo[n][k] != 0) return memo[n][k] == 1;

        boolean pick = help(n - 1, k - arr[n], arr, memo);
        boolean notPick = help(n - 1, k, arr, memo);

        memo[n][k] = (pick || notPick)? 1: -1;
        return pick || notPick;
    }
}




// Tabulation:
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;

        if (arr[0] <= k) dp[0][arr[0]] = true;
        
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean pick = false;
                if (target - arr[i] >= 0) pick = dp[i - 1][target - arr[i]];
                boolean notPick = dp[i - 1][target];

                dp[i][target] = (pick || notPick);
            }
        }
        return dp[n - 1][k];
    }
}