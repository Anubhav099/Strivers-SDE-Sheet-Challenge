public class Solution {
    private static final int MOD = (int)1e9 + 7;
    public static int findWays(int nums[], int tar) {
        int n = nums.length;
        int[][] memo = new int[n][tar + 1];
        for (int[] row: memo) Arrays.fill(row, -1);
        return rec(n - 1, nums, tar, memo);
    }
    static int rec(int ind, int[] nums, int tar, int[][] memo) {
        if (tar == 0) return 1;
        if (ind == -1) return 0;
        if (memo[ind][tar] != -1) return memo[ind][tar];

        int notTake = rec(ind - 1, nums, tar, memo);
        int take = 0;
        if (nums[ind] <= tar) take += rec(ind - 1, nums, tar - nums[ind], memo);

        return memo[ind][tar] = (take + notTake) % MOD;
    }
}