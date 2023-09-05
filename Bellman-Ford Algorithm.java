/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[S] = 0;
        
        for (int iter = 0; iter < V - 1; iter++) {
            for (ArrayList<Integer> edge: edges) {
                int sourceNode = edge.get(0);
                int neighNode = edge.get(1);
                int weight = edge.get(2);
                if (dist[sourceNode] != 1e8 && dist[sourceNode] + weight < dist[neighNode])
                    dist[neighNode] = dist[sourceNode] + weight;
            }
        }
        // Nth relaxation to check for -ve wieght cycle
        for (ArrayList<Integer> edge: edges) {
                int sourceNode = edge.get(0);
                int neighNode = edge.get(1);
                int weight = edge.get(2);
                if (dist[sourceNode] != 1e8 && dist[sourceNode] + weight < dist[neighNode])
                    return new int[] {-1};
            }
        return dist;
    }
}