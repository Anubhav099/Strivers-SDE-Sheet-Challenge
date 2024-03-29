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
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSame(root.left, root.right);
    }
    boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null)
            return t1 == t2;
        if (t1.val != t2.val)
            return false;
        return (isSame(t1.left, t2.right) && isSame(t1.right, t2.left));
    }
}