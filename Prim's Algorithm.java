// Prim's Algo
	// - Greedy Algo
	// - TC: O(E log E)
	// - SC: O(E)
	// - used to find the MST

class Solution{
    class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
	int spanningTree(int V, int E, int edges[][]){
	    // Building the weighted Adj List
	    List<List<Pair>> adj = new ArrayList<>(V);
	    for (int i = 0; i < V; i++)
	        adj.add(new ArrayList<>());
	    for (int[] edge: edges) {
	        adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
	        adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
	    }
	    
	    // Prim's Algo
	    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
	    boolean[] taken = new boolean[V];
	    int numOfNodesAdded = 0;
	    int minCost = 0;
	    pq.offer(new Pair(0, 0));
	    
	    while (!pq.isEmpty()) {
	        int curVer = pq.peek().node;
	        int curWeight = pq.poll().weight;
	        
	        if (taken[curVer]) continue;
	        
	        taken[curVer] = true;
	        minCost += curWeight;
	        
	        for (Pair pair: adj.get(curVer)) {
	            int neigh = pair.node;
	            int weight = pair.weight;
	            if (!taken[neigh])
	                pq.offer(new Pair(neigh, weight));
	        }
	        
	        numOfNodesAdded++;
	        if (numOfNodesAdded == V) break;
	    }
	   return minCost;
	}
}