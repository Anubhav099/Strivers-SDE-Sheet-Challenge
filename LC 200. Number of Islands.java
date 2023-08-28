// Approach 1
// using DFS of graph
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for (int row = 0; row < vis.length; row++)
            for (int col = 0; col < vis[0].length; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    cnt++;
                    dfs(grid, vis, row, col);
                }
            }
        return cnt;
    }
    void dfs(char[][] grid, boolean[][] vis, int row, int col) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1
            || grid[row][col] == '0' || vis[row][col]) return;

        vis[row][col] = true;
        dfs(grid, vis, row - 1, col);
        dfs(grid, vis, row, col + 1);
        dfs(grid, vis, row + 1, col);
        dfs(grid, vis, row, col - 1);
    }
}


// Approach 2
// using BFS of graph

class Solution {
    private class Pair {
        int row, col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for (int row = 0; row < vis.length; row++)
            for (int col = 0; col < vis[0].length; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    cnt++;
                    bfs(grid, vis, row, col);
                }
            }
        return cnt;
    }
    void bfs(char[][] grid, boolean[][] vis, int startRow, int startCol) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startRow, startCol));
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.poll().col;

            vis[row][col] = true;
            
            if (col < grid[0].length - 1 && grid[row][col + 1] == '1'&& !vis[row][col + 1]) q.offer(new Pair(row, col + 1));
            if (col > 0 && grid[row][col - 1] == '1'&& !vis[row][col - 1]) q.offer(new Pair(row, col - 1));
            if (row < grid.length - 1 && grid[row + 1][col] == '1' && !vis[row + 1][col]) q.offer(new Pair(row + 1, col));
            if (row > 0 && grid[row - 1][col] == '1' && !vis[row - 1][col]) q.offer(new Pair(row - 1, col));
        }
    }
}