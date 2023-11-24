public class Solution {
	static int MOD = (int)1e9 + 7;
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int totSum = Arrays.stream(arr).sum();
		if (totSum - d < 0 || (totSum - d) % 2 == 1) return 0;

		int[][] memo = new int[arr.length][((totSum - d) / 2) + 1];
		for (int[] row: memo) Arrays.fill(row, -1);
		return rec(arr.length - 1, arr, (totSum - d) / 2, memo);
	}
	static int rec(int ind, int[] arr, int target, int[][] memo) {
		if (ind == 0)
			if (arr[0] == 0 && target == 0) return 2;
			else if (target == 0 || arr[0] == target) return 1;
			else return 0;
		if (memo[ind][target] != -1) return memo[ind][target];

		int notPick = rec(ind - 1, arr, target, memo);
		int pick = 0;
		if (arr[ind] <= target) pick = rec(ind - 1, arr, target - arr[ind], memo);

		return memo[ind][target] = (pick + notPick) % MOD;
	}
}