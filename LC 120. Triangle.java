// using memoization
class Solution {
    public int minimumTotal(List<List<Integer>> tria) {
        int n = tria.size();
        List<List<Integer>> dp = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c < r + 1; c++)
                row.add((int) 1e6);
            dp.add(row);
        }
        return rec(0, 0, tria, dp);
    }
    int rec(int row, int col, List<List<Integer>> tria, List<List<Integer>> dp) {
        if (row == tria.size() - 1) return tria.get(row).get(col);
        if (dp.get(row).get(col) != 1e6) return dp.get(row).get(col);

        int down = rec(row + 1, col, tria, dp);
        int right = rec(row + 1, col + 1, tria, dp);

        dp.get(row).set(col, tria.get(row).get(col) + Math.min(down, right));
        return dp.get(row).get(col);
    }
}



// using tabulation
class Solution {
    public int minimumTotal(List<List<Integer>> tria) {
        int n = tria.size();
        int[][] dp = new int[n][n];
        
        for (int col = 0; col < n; col++) dp[n - 1][col] = tria.get(n - 1).get(col);
        for (int row = n - 2; row >= 0; row--)
            for (int col = 0; col < row + 1; col++) {
                int down = dp[row + 1][col];
                int right = dp[row + 1][col + 1];

                dp[row][col] = tria.get(row).get(col) + Math.min(down, right);
            }
            
        return dp[0][0];
    }
}


// space optimization
class Solution {
    public int minimumTotal(List<List<Integer>> tria) {
        int n = tria.size();
        
        int[] below = new int[n];
        for (int col = 0; col < n; col++) below[col] = tria.get(n - 1).get(col);

        for (int row = n - 2; row >= 0; row--)
            for (int col = 0; col < row + 1; col++) {
                int down = below[col];
                int right = below[col + 1];

                below[col] = tria.get(row).get(col) + Math.min(down, right);
            }

        return below[0];
    }
}