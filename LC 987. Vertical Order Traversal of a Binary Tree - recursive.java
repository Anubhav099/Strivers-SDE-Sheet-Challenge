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
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        travel(0, 0, root, map);
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> innerMap: map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> que: innerMap.values())
                while (!que.isEmpty())
                    ans.get(ans.size() - 1).add(que.poll());
        }
        return ans;
    }
    void travel(int x, int y, TreeNode cur, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (cur == null) return;

        if (!map.containsKey(x))
            map.put(x, new TreeMap<>());
        if (!map.get(x).containsKey(y))
            map.get(x).put(y, new PriorityQueue<>());
        map.get(x).get(y).offer(cur.val);

        travel(x - 1, y + 1, cur.left, map);
        travel(x + 1, y + 1, cur.right, map);
    }
}