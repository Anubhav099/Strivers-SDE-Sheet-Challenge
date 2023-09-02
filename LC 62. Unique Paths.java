// using MEMOIZATION
class Solution {
    public int uniquePaths(int m, int n) {
        return soln(0, 0, m, n, new int[m][n]);
    }
    public int soln(int i, int j, int m, int n, int[][] dp) {
        if (i == m || j == n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != 0) return dp[i][j];

        int cnt = 0;      
        cnt += soln(i+1, j, m, n, dp);
        cnt += soln(i, j+1, m, n, dp);

        return dp[i][j] = cnt;
    }
}



// using tabulation
class Solution {
    int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) continue;
                
                int cnt = 0;      
                if (i > 0) cnt += dp[i - 1][j];
                if (j > 0) cnt += dp[i][j - 1];

                dp[i][j] = cnt;

            }

        return dp[m - 1][n - 1];
    }
}



// Space optimized || we only need to know what is just above us and on the immediate left of us at any time.
class Solution {
    int uniquePaths(int m, int n) {
        int up[] = new int[n];
        int left = 1;

        for (int i = 0; i < m; i++) {
            if (i != 0) left = 0;
            for (int j = 0; j < n; j++) {

                int cnt = 0;      
                cnt += up[j];
                cnt += left;

                up[j] = left = cnt;
            }
        }

        return left;
    }
}



// Math trick: We need to find the number of ways we can select either (n-1) or (m-1) objects out of (m-1 + n-1) options. i.e. we can find the Combination
class Solution {
    int nCr(int n, int r) {
        double ans = 1;
        for (int i = 0; i < r; i++) {
            ans *= n-i;
            ans /= i+1;
        }
        return (int) ans;
    }

    public int uniquePaths(int m, int n) {
        return nCr(m + n - 2, Math.min(m, n) - 1);
    }
}