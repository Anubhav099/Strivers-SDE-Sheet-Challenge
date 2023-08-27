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


// BFS Approach (Kahn's Algo)

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        for (ArrayList<Integer> li: adj)
            for (int i: li)
                indegree[i]++;
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0)
                q.offer(i);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int n: adj.get(cur))
                if (--indegree[n] == 0)
                    q.offer(n);
        }
        for (int i: indegree)
            if (i != 0)
                return true;
        return false;
    }
}

