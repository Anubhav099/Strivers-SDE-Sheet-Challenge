// Dijkstra Algo
	// - Single Source Shortest Path (SSSP)
	// - does not work with -ve edge weights
	// - Its a Greedy Algo.
	// - Involves theory of "Tense" edge and their "Relaxation".

// IMPLEMENTAION
// using PriorityQueue || TC: O(E*logV)
class Solution
{
    class Pair {
        int dis, node;
        Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        heap.offer(new Pair(S, 0));
        dist[S] = 0;
        
        while (!heap.isEmpty()) {
            int curVertex = heap.peek().node;
            int curVertexDis = heap.poll().dis;
            
            if (curVertexDis > dist[curVertex]) continue;
            
            for (ArrayList<Integer> li: adj.get(curVertex)) {
                int neighVertex = li.get(0);
                int edgeWeight = li.get(1);
                
                if (curVertexDis + edgeWeight < dist[neighVertex]) {
                    dist[neighVertex] = curVertexDis + edgeWeight;
                    heap.offer(new Pair(neighVertex, dist[neighVertex]));
                }
            }
        }
        return dist;
    }
}
// Queue<Pair> heap = new LinkedList<>(); <- a queue also works here instead of min-heap but not as efficient for this purpose



// using Set (just a little better)
// C++ code since this approach is not possible in Java
vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
{
    set<pair<int,int>> st; 
    vector<int> dist(V, 1e9); 
    st.insert({0, S}); 
    dist[S] = 0;
    
    while(!st.empty()) {
        auto it = *(st.begin()); 
        int node = it.second; 
        int dis = it.first; 
        st.erase(it); 

        for(auto it : adj[node]) {
            int adjNode = it[0]; 
            int edgW = it[1]; 
            
            if(dis + edgW < dist[adjNode]) {
                if(dist[adjNode] != 1e9) 
                    st.erase({dist[adjNode], adjNode}); 
                    
                dist[adjNode] = dis + edgW; 
                st.insert({dist[adjNode], adjNode}); 
             }
        }
    }
    return dist; 
}