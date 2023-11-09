class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = Arrays.stream(nums).sum();
        int newTar = totSum - target;
        if (newTar % 2 == 1 || newTar < 0) return 0;
        newTar /= 2;

        int[][] memo = new int[nums.length][newTar + 1];
        for (int[] row: memo) Arrays.fill(row, -1);

        return rec(0, nums, newTar, memo);
    }
    int rec(int ind, int[] nums, int t, int[][] memo) {
        if (ind == nums.length) return t == 0 ? 1: 0;
        if (memo[ind][t] != -1) return memo[ind][t];

        int notTake = rec(ind + 1, nums, t, memo);
        int take = 0;
        if (nums[ind] <= t) take = rec(ind + 1, nums, t - nums[ind], memo);

        return memo[ind][t] = take + notTake;
    }
}