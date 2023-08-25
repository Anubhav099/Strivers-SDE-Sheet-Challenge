/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return node;
        HashMap<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, HashMap<Integer, Node> map) {
        if (map.containsKey(node.val))
            return map.get(node.val);

        Node newNode = new Node(node.val);
        map.put(node.val, newNode);

        for (Node nb : node.neighbors)
            newNode.neighbors.add(clone(nb, map));

        return newNode;
    }
}

// TC: O(2E), SC: O(n)