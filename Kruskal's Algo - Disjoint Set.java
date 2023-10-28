class DisjointSet {
    int[] size, parent;
    DisjointSet(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]); // path compression
    }
    
    void union(int u, int v) {  // union by size
        int root_u = findParent(u);
        int root_v = findParent(v);
        if (root_v == root_u) return;
        
        if (size[root_v] > size[root_u]) {
            parent[root_u] = root_v;
            size[root_v] += size[root_u];
        } else {
            parent[root_v] = root_u;
            size[root_u] += size[root_v];
        }
    }
}
class Solution{
	int spanningTree(int V, int E, int edges[][]){
	    // Kruskal's Algo
	    int minCost = 0;
	    DisjointSet ds = new DisjointSet(V);
	    
	    Arrays.sort(edges, (a, b) -> a[2] - b[2]);
	    
	    for (int[] edge: edges) {
	        int ulp_u = ds.findParent(edge[0]);
	        int ulp_v = ds.findParent(edge[1]);
	        
	        if (ulp_u == ulp_v) continue;
	        
	        minCost += edge[2];
	        
	        ds.union(ulp_u, ulp_v);
	    }
	    return minCost;
	}
}