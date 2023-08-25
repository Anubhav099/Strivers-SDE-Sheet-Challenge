class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // Start DFS from vertex 0
        stack.push(0);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (!visited[cur]) {
                visited[cur] = true;
                ans.add(cur);
            }

            for (int neighbor : adj.get(cur))
                if (!visited[neighbor])
                    stack.push(neighbor);
        }  

        return ans;
    }
}