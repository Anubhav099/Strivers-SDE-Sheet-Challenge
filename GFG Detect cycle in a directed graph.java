// DFS Approach

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] dfsVis = new boolean[V];
        
        for (int i = 0; i < V; i++)
            if (!vis[i]) 
                if (dfs(i, adj, vis, dfsVis)) return true;
                
        return false;
    }
    private boolean dfs(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] curVis) {
        if (curVis[cur]) return true;
        if (vis[cur]) return false;
        
        vis[cur] = curVis[cur] = true;
        
        for (int neighbor: adj.get(cur))
            if (dfs(neighbor, adj, vis, curVis)) return true;
            
        curVis[cur] = false;
        
        return false;
    }
}


// BFS Approach

