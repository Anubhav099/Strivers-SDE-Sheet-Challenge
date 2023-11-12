class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for (int via = 0; via < n; via++)
            for (int src = 0; src < n; src++)
                for (int dest = 0; dest < n; dest++) {
                    int srcToDest = matrix[src][dest];
                    int srcToVia = matrix[src][via];
                    int viaToDest = matrix[via][dest];
                    if (srcToVia != -1 && viaToDest != -1)
                        if (srcToDest == -1 || srcToVia + viaToDest < srcToDest)
                            matrix[src][dest] = srcToVia + viaToDest;
                }
    }
}
// TC: O(n^3)


// In this question, -ve cycles weren't allowed. Hence, we can just use Dij algo (SSSP algo) for every vertex.
// TC: O(n*n*logV)
// Note: if -ve cycle is present, this dijkstra's approach will fall under an infinite loop.
class Solution
{
    class Pair {
        int node, dis;
        Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for (int i = 0; i < n; i++)
            matrix[i] = dijkstra(n, matrix, i);
        
    }
    int[] dijkstra(int n, int[][] matrix, int start)
    {
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        heap.offer(new Pair(start, 0));
        dist[start] = 0;
        
        while (!heap.isEmpty()) {
            int curVertex = heap.peek().node;
            int curVertexDis = heap.poll().dis;
            
            if (curVertexDis > dist[curVertex]) continue;
            
            for (int neigh = 0; neigh < n; neigh++) {
                if (matrix[curVertex][neigh] == -1) continue;
                int edgeWeight = matrix[curVertex][neigh];
                
                if (curVertexDis + edgeWeight < dist[neigh]) {
                    dist[neigh] = curVertexDis + edgeWeight;
                    heap.offer(new Pair(neigh, dist[neigh]));
                }
            }
        }
        for (int i = 0; i < n; i++)
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        return dist;
    }
}