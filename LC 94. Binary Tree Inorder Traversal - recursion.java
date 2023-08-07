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
        trav(root, ans);
        return ans;
    }
    void trav( TreeNode cur, List<Integer> ans) {
        if (cur == null) return;

        trav( cur.left, ans);
        ans.add(cur.val);
        trav( cur.right, ans);
    }
}