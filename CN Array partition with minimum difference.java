public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int totSum = Arrays.stream(arr).sum();
        boolean[][] dp = new boolean[arr.length][totSum + 1];

        for (int ind = 0; ind < arr.length; ind++) dp[ind][0] = true;
        if (arr[0] <= totSum) dp[0][arr[0]] = true;

        for (int ind = 1; ind < arr.length; ind++) {
            for (int target = 1; target <= totSum; target++) {
                boolean notPick = dp[ind - 1][target];
                boolean pick = false;
                if (arr[ind] <= target) pick = dp[ind - 1][target - arr[ind]];
                dp[ind][target] = pick | notPick;
            }
        }

        int mini = Integer.MAX_VALUE;
        for (int target = 0; target <= totSum; target++)
            if (dp[arr.length - 1][target])
                mini = Math.min(mini, Math.abs(target - (totSum - target)));
        return mini;
    }
}