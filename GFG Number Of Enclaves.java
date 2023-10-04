class Solution {

    int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int total = 0;
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int[] visCnt = new int[] {0};
                    boolean onTheEdge = dfs(r, c, grid, n, m, visCnt, visited);
                    if (!onTheEdge)
                        total += visCnt[0];
                }
            }
        return total;
    }
    boolean dfs(int r, int c, int[][] grid, int n, int m, int[] visCnt, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= n || c >= m) return true;
        if (grid[r][c] == 0 || visited[r][c]) return false;
        
        visCnt[0]++;
        visited[r][c] = true;
        
        boolean onTheEdge = false;
        int[] dir = {-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            onTheEdge |= dfs(r + dir[d], c + dir[d + 1], grid, n, m, visCnt, visited);
        }
        return onTheEdge;
    }
}




// More optimized version:
class Solution {

    int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
	// boundary traversal
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) dfs(0, i, grid, n, m);
            if (grid[n - 1][i] == 1) dfs(n - 1, i, grid, n, m);
        }
        for (int j = 0; j < n; j++) {
            if (grid[j][0] == 1) dfs(j, 0, grid, n, m);
            if (grid[j][m - 1] == 1) dfs(j, m - 1, grid, n, m);
        }
        
	// Now, anything left as 1 is not touched by the boundary.
        int total = 0;
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++)
                if (grid[r][c] == 1) total++;
        return total;
    }
    void dfs(int r, int c, int[][] grid, int n, int m) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0) return;
        
        grid[r][c] = 0;
        
        int[] dir = {-1, 0, 1, 0, -1};
        for (int d = 0; d < 4; d++)
            dfs(r + dir[d], c + dir[d + 1], grid, n, m);
    }
}