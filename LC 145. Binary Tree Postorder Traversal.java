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
        if (root != null) travel(root, ans);
        return ans;
    }
    void travel(TreeNode cur, List<Integer> li) {
        if (cur.left != null) travel(cur.left, li);
        if (cur.right != null) travel(cur.right, li);
        li.add(cur.val);
    }
}