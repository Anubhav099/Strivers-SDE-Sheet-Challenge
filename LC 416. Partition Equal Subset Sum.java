// Brute Force with memoization
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i: nums) sum += i;
        if (sum % 2 == 1) return false;

        int[][] dp = new int[n][sum + 1];
        return rec(0, nums, n, 0, sum, dp);
    }
    boolean rec(int ind, int[] nums, int n, int leftSum, int rightSum, int[][] dp) {
        if (leftSum == rightSum) return true;
        if (ind == n || rightSum <= 0) return false;
        if (dp[ind][leftSum] != 0) return dp[ind][leftSum] == 1;

        boolean notPick = rec(ind + 1, nums, n, leftSum, rightSum, dp);
        boolean pick = rec(ind + 1, nums, n, leftSum + nums[ind], rightSum - nums[ind], dp);

        dp[ind][leftSum] = (pick | notPick)? 1: -1;
        return pick | notPick;
    }
}



// Better Memoization:
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i: nums) sum += i;
        if (sum % 2 == 1) return false;

        int[][] dp = new int[n][sum + 1];
        return isHalfSum(n - 1, sum / 2, nums, n, dp);
    }
    boolean isHalfSum(int ind, int sum, int[] nums, int n, int[][] dp) {
        if (sum == 0) return true;
        if (ind < 0 || sum < 0) return false;
        if (dp[ind][sum] != 0) return dp[ind][sum] == 1;

        boolean notPick = isHalfSum(ind - 1, sum, nums, n, dp);
        boolean pick = isHalfSum(ind - 1, sum - nums[ind], nums, n, dp);

        dp[ind][sum] = (pick | notPick)? 1: -1;
        return pick | notPick;
    }
}




// Tabulation:
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;

        sum /= 2;
        return subsetSumToK(n, sum, nums);
    }
    private boolean subsetSumToK(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;

        if (arr[0] <= k) dp[0][arr[0]] = true;
        
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notPick = dp[i - 1][target];
                boolean pick = false;
                if (target - arr[i] >= 0) pick = dp[i - 1][target - arr[i]];

                dp[i][target] = (pick || notPick);
            }
        }
        return dp[n - 1][k];
    }
}




// Optimal Soln:
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num: nums)
            for (int target = sum; target >= num; target--)
                if (dp[target - num])
                    dp[target] = true;
        return dp[sum];
    }
}
