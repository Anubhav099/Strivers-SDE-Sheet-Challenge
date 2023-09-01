// Using memoization
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int l = dfs(nums.length - 2, nums, dp, 0);
        Arrays.fill(dp, -1);
        int r = dfs(nums.length - 1, nums, dp, 1);

        return Math.max(l, r);
    }
    int dfs(int ind, int[] nums, int[] dp, int end) {
        if (ind == end) return nums[end];
        if (ind < end) return 0;
        if (dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + dfs(ind - 2, nums, dp, end);
        int notPick = dfs(ind - 1, nums, dp, end);

        return dp[ind] = Math.max(pick, notPick);
    }
}



// Using tabulation
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            int pick = nums[i]; if (i > 1) pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        int l = dp[n - 2];

        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            int pick = nums[i]; if (i > 2) pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        int r = dp[n - 1];        

        return Math.max(l, r);
    }
}



// Space optimized  : TC: O(n), SC: O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int prev = nums[0], prev2 = 0, back = nums[1], back2 = 0;
        for (int i = 1; i < n; i++) {
            if (i != n - 1) {
                int pick = nums[i]; if (i > 1) pick += prev2;
                int notPick = prev;

                prev2 = prev;
                prev = Math.max(pick, notPick);
            }

            if (i != 1) {
                int pick = nums[i]; if (i > 2) pick += back2;
                int notPick = back;

                back2 = back;
                back = Math.max(pick, notPick);
            }
        }

        return Math.max(prev, back);
    }
}