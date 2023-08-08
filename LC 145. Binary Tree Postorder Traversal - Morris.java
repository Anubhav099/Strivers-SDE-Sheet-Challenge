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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                ans.add(0, cur.val);
                cur = cur.left;
            }
            else {
                TreeNode prev = cur.right;
                while ( prev.left != null && prev.left != cur)
                    prev = prev.left;
                if (prev.left == null) {
                    prev.left = cur;
                    ans.add(0, cur.val);
                    cur = cur.right;
                }
                else {
                    prev.left = null;
                    cur = cur.left;
                }
            }
        }
        return ans;
    }
}
// The deriving intuition is same as the intution for iterative approach from pre to post.
// In pre we traverser in order -> root, left, right
// We traverse here in the order -> root, right, left and add to the list in reverse.