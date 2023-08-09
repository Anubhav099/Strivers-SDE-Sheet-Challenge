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
    public int maxDepth(TreeNode root) {
        return travel(1, root);
    }

    int travel(int level, TreeNode cur) {
        if (cur == null) return level - 1;
        int maxLevel = level;
        maxLevel = Math.max(maxLevel, travel(level + 1, cur.left));
        maxLevel = Math.max(maxLevel, travel(level + 1, cur.right));
        return maxLevel;
    }
}

// More concise code:
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int ri8 = maxDepth(root.right);

        return Math.max(left, ri8) + 1;
    }
}

// This can also be solved using level order traversal with queue but it won't be effiecient space complexity wise.