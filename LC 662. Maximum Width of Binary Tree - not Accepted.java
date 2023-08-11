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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return 0;
        int maxWid = 1;
        q.offer(root);
        while (true) {
            int noOfNodes = q.size();
            TreeNode cur;
            boolean foundFirst = false;
            int left = -1, right = -1;
            for (int i = 0; i < noOfNodes; i++) {
                cur = q.poll();
                if (cur == null) {
                    q.offer(null);
                    q.offer(null);
                } else {
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
                if ( cur != null && !foundFirst) {
                    left = i;
                    foundFirst = true;
                }
                if (cur != null) right = i;
            }
            if (left == -1) break; 
            maxWid = Math.max(maxWid, right - left + 1);
            
        }
        return maxWid;
    }
}
// Correct but not optimal.