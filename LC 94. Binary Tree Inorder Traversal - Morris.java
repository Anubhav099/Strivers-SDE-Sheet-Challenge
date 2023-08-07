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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
// this will move the ptr form the last rightmost node of the left sub tree to the parent node that it needs to return. Only in the last case it will make it point to null when there will be no parent to return to.
            }
            else {
                TreeNode prev = cur.left;
// This prev ptr traverses till the rightmost node of the left sub tree twice for every node (first time, before visiting the left subtree and once after returning from the visit).
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                }
                else if (prev.right == cur) {
                    prev.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}
// Morris Traversal -> O(n) , O(1)
// Brute force -> O(n), O(n)