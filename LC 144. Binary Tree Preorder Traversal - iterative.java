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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<TreeNode> stk = new Stack<>(); // To backtrack to last node
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            ans.add(cur.val);
            if (cur.right != null) stk.push(cur.right); // first push the right node
            if (cur.left != null) stk.push(cur.left); // then push the left so that the left is popped first and is visited before the right
        }
        return ans;
    }
}