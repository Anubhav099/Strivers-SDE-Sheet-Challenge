// Memo - 1
public class Solution {
    public static int minimumElements(int num[], int x) {
        int[][] memo = new int[num.length][x + 1];
        for (int[] row: memo) Arrays.fill(row, -1);
        int ans = rec(num.length - 1, num, x, memo);
        return ans >= 1e9? -1: ans;
    }
    static int rec(int ind, int[] nums, int target, int[][] memo) {
        if (target == 0) return 0;
        if (ind == -1) return (int)1e9;
        if (memo[ind][target] != -1) return memo[ind][target];

        int notTake = rec(ind - 1, nums, target, memo);
        int take = (int)1e9;
        if (nums[ind] <= target) take = Math.min(take, 1 + rec(ind, nums, target - nums[ind], memo));

        return memo[ind][target] = Math.min(take, notTake);
    }
}


// Memo - 2
public class Solution {
    public static int minimumElements(int num[], int x) {
        int[] memo = new int[x + 1];
        Arrays.fill(memo, -1);
        int ans = rec(num, x, memo);
        return ans >= 1e9? -1: ans;
    }
    static int rec(int[] nums, int target, int[] memo) {
        if (target == 0) return 0;
        if (memo[target] != -1) return memo[target];

        int mini = (int)1e9;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) mini = Math.min(mini, 1 + rec(nums, target - nums[i], memo));
        }
        return memo[target] = mini;
    }
}



// Tabulation
public class Solution {
    public static int minimumElements(int nums[], int x) {
        int[][] dp = new int[nums.length][x + 1];
        
        for (int i = 0; i < nums.length; i++) {
            for (int t = 1; t <= x; t++) {

                int notTake = (int)1e9;
                if (i > 0) notTake = dp[i - 1][t];
                int take = (int)1e9;
                if (nums[i] <= t) take = Math.min(take, 1 + dp[i][t - nums[i]]);

                dp[i][t] = Math.min(take, notTake);
            }
        }

        return dp[nums.length - 1][x] == 1e9? -1: dp[nums.length - 1][x];
    }
}