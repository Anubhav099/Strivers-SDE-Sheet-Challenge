// using memoization
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row: dp) Arrays.fill(row, -1);
        
        return rec(n - 1, m - 1, grid, dp);
    }
    int rec(int r, int c, int[][] grid, int[][] dp) {
        if (r == 0 && c == 0) return grid[r][c];
        if (r < 0 || c < 0) return Integer.MAX_VALUE;
        if (dp[r][c] != -1) return dp[r][c];
        
        int up = rec(r - 1, c, grid, dp);
        int left = rec(r, c - 1, grid, dp);

        return dp[r][c] = grid[r][c] + Math.min(up, left);
    }
}



// using tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int row = 0; row < n; row ++) {
            for (int col = 0; col < m; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                    continue;
                }
                int up = Integer.MAX_VALUE, left = up;
                if (row > 0) up = dp[row - 1][col];
                if (col > 0) left = dp[row][col - 1];

                dp[row][col] = grid[row][col] + Math.min(up, left);
            }
        }
        return dp[n - 1][m - 1];
    }
}



// space optimization
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] up = new int[m];

        for (int row = 0; row < n; row ++) {
            for (int col = 0; col < m; col++) {
                if (row == 0 && col == 0) {
                    up[col] = grid[row][col];
                    continue;
                }
                int UP = Integer.MAX_VALUE, left = UP;
                if (row > 0) UP = up[col];
                if (col > 0) left = up[col - 1];

                up[col] = grid[row][col] + Math.min(UP, left);
            }
        }
        return up[m - 1];
    }
}