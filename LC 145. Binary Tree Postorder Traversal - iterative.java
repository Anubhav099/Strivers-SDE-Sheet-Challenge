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
        if (root == null) return ans;

        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);

        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            ans.add(0, cur.val);
            if (cur.left != null) stk.push(cur.left);
            if (cur.right != null) stk.push(cur.right);
        }
        return ans;
    }
}
// We visit the nodes in the order -> cur, right, left and add to the list in reverse.
// The only difference between the pre and post is that
// in pre we visited in the order -> cur, left, right and added to the list in the same order.