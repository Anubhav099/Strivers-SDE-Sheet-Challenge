class Solution {
    class Pair {
        int node, dis;
        Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
    
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Building the Adjacency List
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        // Dijkstra's adgo initial-config
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        heap.offer(new Pair(1, 0));
        dis[1] = 0;
        int[] parent = new int[n + 1]; // to keep track of the best way to reach the node
        
        while (!heap.isEmpty()) {
            int curNode = heap.peek().node;
            int curDist = heap.poll().dis;
            
            for (Pair neigh: adj.get(curNode)) {
                if (curDist + neigh.dis < dis[neigh.node]) {
                    parent[neigh.node] = curNode;
                    dis[neigh.node] = curDist + neigh.dis;
                    heap.offer(new Pair(neigh.node, curDist + neigh.dis));
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int curInd = n;
        while (curInd != 0) {
            ans.add(curInd);
            curInd = parent[curInd];
        }
        Collections.reverse(ans);
        
        // System.out.println(Arrays.toString(Arrays.copyOfRange(parent, 1, parent.length)));
        // System.out.println(Arrays.toString(Arrays.copyOfRange(dis, 1, dis.length)));
        return parent[n] == 0? new ArrayList<>(Arrays.asList(-1)): ans;
    }
}