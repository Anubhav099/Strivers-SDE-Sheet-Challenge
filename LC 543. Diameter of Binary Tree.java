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
    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger ans = new AtomicInteger();
        travel(root, ans);
        return ans.get();
    }
    public int travel(TreeNode root, AtomicInteger max) {
        if (root == null) return 0;
        int left = travel(root.left, max);
        int right = travel(root.right, max);

        max.set(Math.max(left+right, max.get()));

        return Math.max(left, right) + 1;
    }
}
// AtomicInteger in java is just a mutable int.