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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            if (--k == 0) return cur.val;
            cur = cur.right;
        }
        return -1;
    }
}

// recursive

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] cnt = new int[]{k};
        return find(root, cnt);
    }

    private int find(TreeNode root, int[] cnt) {
        if (root == null) return 0;
        int left = find(root.left, cnt);
        if (left != 0) return left;
        if (--cnt[0] == 0) return root.val;
        return find(root.right, cnt);
    }
}