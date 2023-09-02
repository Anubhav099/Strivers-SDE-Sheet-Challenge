// using MEMOIZATION
public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        int[] dp = new int[n];
        return dfs(n - 1, k, height, dp);
    }
    static int dfs(int ind, int k, int[] h, int[] dp) {
        if (ind == 0) return 0;
        if (ind < 0) return Integer.MAX_VALUE;
        if (dp[ind] != 0) return dp[ind];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int curMin = Integer.MAX_VALUE;
            if (ind - i >= 0)
                curMin = dfs(ind - i, k, h, dp) + Math.abs(h[ind] - h[ind - i]);
            min = Math.min(curMin, min);
        }

        return dp[ind] = min;
    }
}



// using TABULATION
public class Solution {
    public static int minimizeCost(int n, int k, int []h){
        // Write your code here.
        int[] dp = new int[n];
        
        dp[0] = 0;
        for (int ind = 1; ind < n; ind++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                int curMin = Integer.MAX_VALUE;
                if (ind - i >= 0)
                    curMin = dp[ind - i] + Math.abs(h[ind] - h[ind - i]);
                min = Math.min(curMin, min);
            }
            dp[ind] = min;
        }

        return dp[n - 1];
    }
}



// Space Optimized TC: O(n * k), SC: O(k)
public class Solution {
    public static int minimizeCost(int n, int k, int []h){
        // Write your code here.
        List<Integer> prev = new ArrayList<>(k);
        for (int i = 0; i < k; i++)
            prev.add(0);
        
        for (int ind = 1; ind < n; ind++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                int curMin = Integer.MAX_VALUE;
                if (ind - i >= 0)
                    curMin = prev.get(k - i) + Math.abs(h[ind] - h[ind - i]);
                min = Math.min(curMin, min);
            }
            prev.remove(0); // remove the first elem
            prev.add(min);  // add the new elem to the end to maintain the size of just k elements.
        }
        
        return prev.get(k - 1);
    }
}