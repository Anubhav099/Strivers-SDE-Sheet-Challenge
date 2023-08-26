// DFS Approach

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] vis = new boolean[V];
        int[] ans = new int[V];
        int ind = V - 1;
        for (int i = 0; i < V; i++)
            if (!vis[i])
                ind = dfs(i, adj, vis, ind, ans);
        return ans;
    }
    static int dfs(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int ind, int[] ans) {
        vis[cur] = true;
        for (int i: adj.get(cur))
            if (!vis[i])
                ind = dfs(i, adj, vis, ind, ans);
        ans[ind--] = cur;
        return ind;
    }
}

// BFS Approach

