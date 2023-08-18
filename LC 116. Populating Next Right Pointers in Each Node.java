/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// BRUTE FORCE
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) return null;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                if (size != 0) cur.next = q.peek();
            }
        }
        return root;
    }
}

// Recursive approach (Better)

class Solution {
    public Node connect(Node root) {
        travel(root, null);
        return root;
    }

    void travel(Node cur, Node next) {
        if (cur == null) return;

        cur.next = next;
        travel(cur.left, cur.right);
        travel(cur.right, next == null ? null : next.left);
    }
}