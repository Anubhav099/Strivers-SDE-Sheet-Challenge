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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxHeight(root.left) - maxHeight(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    int maxHeight(TreeNode root) {
        if (root == null) return 0;
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        return Math.max(left, right) + 1;
    }
}

// Smart Approach:
class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightOrErr(root) != -1;
    }
    int heightOrErr(TreeNode cur) {
        if (cur == null) return 0;

        int left = heightOrErr(cur.left);
        if (left == -1) return -1;
        int right = heightOrErr(cur.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
// This code traverses the tree only once, rather than finding height at every node which means traversing the whole subtree at every step.