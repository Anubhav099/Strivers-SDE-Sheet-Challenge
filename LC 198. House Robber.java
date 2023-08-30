// Recursion with memoization
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(nums.length - 1, nums, dp);
    }
    int f(int ind, int[] nums, int[] dp) {
        if (ind == 0) return nums[0];
        if (ind < 0) return 0;
        if (dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + f(ind - 2, nums, dp);
        int notPick = f(ind - 1, nums, dp);

        return dp[ind] = Math.max(pick, notPick);
    }
}


// Tabulation
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        dp[n - 2] = Math.max(nums[n - 2], nums[n-1]);

        for (int i = n - 3; i >= 0; i--) {
            int left = dp[i + 2] + nums[i];
            int right = dp[i + 1];
            dp[i] = Math.max(left, right);
        }
        return dp[0];
    }
}

// Space optimized
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int next2 = nums[n - 1];
        int next = Math.max(nums[n - 2], nums[n-1]);

        for (int i = n - 3; i >= 0; i--) {
            int left = next2 + nums[i];
            int right = next;
            next2 = next;
            next = Math.max(left, right);
        }
        return next;
    }
}