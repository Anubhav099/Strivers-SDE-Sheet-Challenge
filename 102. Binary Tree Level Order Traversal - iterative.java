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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int noOfNodes = q.size();
            List<Integer> li = new ArrayList<>();
            while (noOfNodes-- > 0) {
                if (q.peek().left != null) q.add(q.peek().left);
                if (q.peek().right != null) q.add(q.peek().right);
                li.add(q.poll().val);
            }
            ans.add(li);
        }
        return ans;
    }
}