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
    public void flatten(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        if (root != null) {
            inOrder(root, ans);
            root.left = null;
            root.right = ans.right.right;
        }
    }
    
    TreeNode inOrder(TreeNode cur, TreeNode ans) {
        if (cur == null) return ans;
        
        ans.right = new TreeNode(cur.val);
        ans = ans.right;
        
        ans = inOrder(cur.left, ans);
        ans = inOrder(cur.right, ans);

        return ans;
    }
}

// 2nd Approach:

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }
}

// 3rd Approach: (using a stack)

class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();

        if (root == null) return;

        stk.push(root);

        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();

            if (cur.right != null) stk.push(cur.right);
            if (cur.left != null) stk.push(cur.left);

            if (!stk.isEmpty()) cur.right = stk.peek();
            cur.left = null;
        }
    }
}

// 4th Approach: (Morris Traversal)

class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode prev = root.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}