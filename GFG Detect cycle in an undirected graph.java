// DFS approach

class Solution {
    private class Pair {
        int node;
        int parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!vis[i])
                if (bfs(i, adj, vis)) return true;
        return false;
    }
    
    private boolean bfs(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        
        vis[cur] = true;
        q.offer(new Pair(cur, -1));
        
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.poll().parent;
            
            for (int i: adj.get(node))
                if (!vis[i]) {
                    vis[i] = true;
                    q.offer(new Pair(i, node));
                } else if(i != parent)
                    return true;
        }
        return false;
    }
}


// BFS Approach

class Solution {
    private class Pair {
        int node;
        int parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < V; i++)
            if (!vis[i])
                if (dfs(new Pair(i, -1), adj, vis, set)) return true;
                
        return false;
    }
    
    private boolean dfs(Pair cur, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Set<Integer> set) {
        if (!set.add(cur.node)) return true;
        
        vis[cur.node] = true;
        for (int i: adj.get(cur.node))
            if (i != cur.parent)
                if(dfs(new Pair(i, cur.node), adj, vis, set)) return true;
                
        set.remove(cur.node);
        return false;
    }
}