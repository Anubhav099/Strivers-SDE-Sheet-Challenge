class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[0].length; col++)
                if (grid[row][col] == '1') {
                    cnt++;
                    visit(grid, row, col);
                }
        return cnt;
    }
    void visit(char[][] g, int row, int col) {
        if (row < 0 || col < 0 || row >= g.length || col >= g[0].length || g[row][col] == '0') return;
        g[row][col] = '0';
        visit(g, row + 1, col);
        visit(g, row - 1, col);
        visit(g, row, col + 1);
        visit(g, row, col - 1);
    }
}