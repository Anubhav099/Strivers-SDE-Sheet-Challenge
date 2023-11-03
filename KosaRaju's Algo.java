class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Step 1: Implement the TopoSort algo
        Stack<Integer> stk = topoSort(V, adj);
        
        // Step 2: Transpose the given graph
        List<List<Integer>> transAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) transAdj.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            List<Integer> neighList = adj.get(i);
            for (int neigh: neighList) {
                transAdj.get(neigh).add(i);
            }
        }
        
        // Step 3: Use the Stack(Reverse TopoSorted nodes) and Transposed list to visit one set of SCC in each DFS call
        int cntOfSCC = 0;
        boolean[] vis = new boolean[V];
        while (!stk.isEmpty()) {
            int curNode = stk.pop();
            if (!vis[curNode]) {
                cntOfSCC++;
                dfs(curNode, transAdj, vis);
            }
        }
        
        return cntOfSCC;
    }
    void dfs(int curNode, List<List<Integer>> transAdj, boolean[] vis) {
        vis[curNode] = true;
        
        for (int neigh: transAdj.get(curNode)) {
            if (!vis[neigh]) dfs(neigh, transAdj, vis);
        }
    }
    Stack<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topoDFS(i, adj, vis, stk);
            }
        }
        return stk;
    }
    void topoDFS(int curNode, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> stk) {
        vis[curNode] = true;
        
        for (int neigh: adj.get(curNode)) {
            if (!vis[neigh]) topoDFS(neigh, adj, vis, stk);
        }
        
        stk.push(curNode);
    }
}