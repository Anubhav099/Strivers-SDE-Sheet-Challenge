class Solution {
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        Queue<Pair> q= new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (mat[i][j] == 0) {
                    vis[i][j] = true;
                    q.offer(new Pair(i, j));
                }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans[][] = new int[n][m];
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.poll().y;

            for (int[] dir: dirs) {
                int curX = x + dir[0];
                int curY = y + dir[1];
                if (curX >= 0 && curX < n && curY >= 0 && curY < m && !vis[curX][curY]) {
                    ans[curX][curY] = ans[x][y] + 1;
                    vis[curX][curY] = true;
                    q.offer(new Pair(curX, curY));
                }
            }
        }
        return ans;
    }
}