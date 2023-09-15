// using memoization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        long dp[][] = new long[matrix.length][matrix[0].length];
        for (long row[]: dp) Arrays.fill(row, Integer.MIN_VALUE);

        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++)
            ans = Math.min(ans, rec(0, i, matrix, dp));
            
        return (int)ans;
    }
    long rec(int r, int c, int[][] mat, long[][] dp) {
        if (r == mat.length - 1)
            return mat[r][c];
        if (dp[r][c] != Integer.MIN_VALUE) return dp[r][c];

        long sum = rec(r + 1, c, mat, dp);
        if (c > 0) sum = Math.min(sum,  rec(r + 1, c - 1, mat, dp));
        if (c < mat[0].length - 1) sum = Math.min(sum,  rec(r + 1, c + 1, mat, dp));

        return dp[r][c] = sum + mat[r][c];
    }
}



// using tabulation
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int dp[][] = new int[n][m];
        dp[n - 1] = matrix[n - 1];

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < m; col++) {
                int sum = dp[row + 1][col];
                if (col > 0) sum = Math.min(sum,  dp[row + 1][col - 1]);
                if (col < m - 1) sum = Math.min(sum,  dp[row + 1][col + 1]);

                dp[row][col] = sum + matrix[row][col];
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int start = 0; start < m; start++)
            ans = Math.min(ans, dp[0][start]);
        
        return ans;
    }
}



// space optimization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int[] down = Arrays.copyOf(matrix[n - 1], m);

        for (int row = n - 2; row >= 0; row--) {
            int cur[] = new int[m];
            for (int col = 0; col < m; col++) {
                int sum = down[col];
                if (col > 0) sum = Math.min(sum,  down[col - 1]);
                if (col < m - 1) sum = Math.min(sum,  down[col + 1]);

                cur[col] = sum + matrix[row][col];
            }
            down = cur;
        }
        
        int ans = Integer.MAX_VALUE;
        for (int start = 0; start < m; start++)
            ans = Math.min(ans, down[start]);
        
        return ans;
    }
}