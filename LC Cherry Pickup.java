class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] dp = new int[n][n][n][n];
        return Math.max(0, rec(0, 0, 0, 0, grid, n, dp));
    }
    int rec(int r1, int c1, int r2, int c2, int[][] grid, int n, int[][][][] dp) {
        if (r1 >= n || c1 >= n || grid[r1][c1] == -1 || r2 >= n || c2 >= n || grid[r2][c2] == -1)
            return (int)-1e7;
        if (r1 == n - 1 && c1 == n - 1)
            return grid[n - 1][n - 1];
        if (dp[r1][c1][r2][c2] != 0) return dp[r1][c1][r2][c2];

        int mx = rec(r1, c1 + 1, r2, c2 + 1, grid, n, dp);
        mx = Math.max(mx, rec(r1, c1 + 1, r2 + 1, c2, grid, n, dp));
        mx = Math.max(mx, rec(r1 + 1, c1, r2 + 1, c2, grid, n, dp));
        mx = Math.max(mx, rec(r1 + 1, c1, r2, c2 + 1, grid, n, dp));

        int additiveFactor = grid[r1][c1];
        if (c1 != c2) additiveFactor += grid[r2][c2]; 
        return dp[r1][c1][r2][c2] = mx + additiveFactor;
    }
}
// some observations:
// 1) the number of steps(time) taken by each of them to a particular r,c such that the r==c (square shaped)) is the SAME. For eg. steps taken to reach a point (3, 3) is always 6, no matter what path you take. 
// In other words, they will only collide at these square points.
// they can't be in the same col if they are in different rows and vice versa is also true.
// From this we can conclude that they both will reach (n - 1, n - 1) at the same exact time.
// 2) Since, we are travelling only down and right, indices can't get -ve vals. no need to check.
// 3) This also means that a cell won't be accessed again anytime after one of them has visited it except for the square cells. So, we only need to take care of the case when they are at a square cell.
// THEREFORE: r1 + c1 == r2 + c2



// Little space optimization: SC: O(n^4) -> O(n^3) [Could be converted to 2D O(n^2)]
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        return Math.max(0, rec(0, 0, 0, grid, n, new int[n][n][n]));
    }
    int rec(int r1, int c1, int c2, int[][] grid, int n, int[][][] dp) {
        int r2 = r1 + c1 - c2;	// calculating r2
        if (r1 >= n || c1 >= n || grid[r1][c1] == -1 || r2 >= n || c2 >= n || grid[r2][c2] == -1)
            return (int)-1e7;
        if (r1 == n - 1 && c1 == n - 1)
            return grid[n - 1][n - 1];
        if (dp[r1][c1][c2] != 0) return dp[r1][c1][c2];

        int mx = rec(r1, c1 + 1, c2 + 1, grid, n, dp);  // automatically r2 will remain same
        mx = Math.max(mx, rec(r1, c1 + 1, c2, grid, n, dp)); // similarly, r2 will increase here
        mx = Math.max(mx, rec(r1 + 1, c1, c2, grid, n, dp)); // r2 will increase here
        mx = Math.max(mx, rec(r1 + 1, c1, c2 + 1, grid, n, dp)); // r2 will remain same

        int additiveFactor = grid[r1][c1];
        if (c1 != c2) additiveFactor += grid[r2][c2]; 
        return dp[r1][c1][c2] = mx + additiveFactor;
    }
}



// Tabulation code from discussion section:
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][]dp = new int[n + 1][n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[1][1][1] = grid[0][0];
        for(int x1 = 1; x1 <= n; x1++){
            for(int y1 = 1; y1 <= n; y1++){
                for(int x2 = 1; x2 <= n; x2++){
                    int y2 = x1 + y1 - x2;
                    if(dp[x1][y1][x2] > 0 || y2 < 1 || y2 > n || grid[x1 - 1][y1 - 1] == -1 || grid[x2 - 1][y2 - 1] == -1)
                        continue;
                        
                    int cur = Math.max(Math.max(dp[x1 - 1][y1][x2], dp[x1 - 1][y1][x2 - 1]), Math.max(dp[x1][y1 - 1][x2], dp[x1][y1 - 1][x2 - 1]));
                    if(cur < 0){
                        continue;
                    }
                    dp[x1][y1][x2] = cur + grid[x1 - 1][y1 - 1];
                    if(x1 != x2){
                        dp[x1][y1][x2] += grid[x2 - 1][y2 - 1];
                    }
                }
            }
        }
        return dp[n][n][n] < 0 ? 0 : dp[n][n][n];
    }
}