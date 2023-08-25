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
                if (help(i, adj, vis)) return true;
        return false;
    }
    
    private boolean help(int cur, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
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