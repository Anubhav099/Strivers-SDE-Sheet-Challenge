/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Element {
    int row;
    int col;
    TreeNode node;
    Element(int row, int col, TreeNode node) {
        this.row = row;
        this.col = col;
        this.node = node;
    } 
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Element> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        //        ^x               ^y            ^min-heap of nodes values
        q.add(new Element(0, 0, root));
        while (!q.isEmpty()) {
            Element e = q.poll();
            TreeNode cur = e.node;
            int x = e.row;
            int y = e.col;
            // Retrived values from the first node in the queue

            if (!map.containsKey(x))
                map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(cur.val);

            // Adding left and right children of the current node to the q
            if (cur.left != null) q.offer(new Element(x - 1, y + 1, cur.left));
            if (cur.right != null) q.offer(new Element(x + 1, y + 1, cur.right));
        }

        // Now, convert the the PriorityQueue at each x into a list
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> innerMap: map.values()) {
            List<Integer> li = new ArrayList<>();
            for (PriorityQueue<Integer> heap: innerMap.values()) {
                // li.addAll(heap); // We can't do this since, a minHeap as list looks like [7, 26, 17]
                while (!heap.isEmpty()) {
                    li.add(heap.poll());
                }
            }
            ans.add(li);
        }
        return ans;
    }
}
// Using level order traversal i.e. BFS i.e. iterative