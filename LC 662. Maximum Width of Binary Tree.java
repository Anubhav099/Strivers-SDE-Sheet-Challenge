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
class Element {
    TreeNode node;
    int num;
    Element(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWid = 1;
        Queue<Element> q = new LinkedList<>();
        q.offer(new Element(root, 1));
        while (!q.isEmpty()) {
            int noOfNodes = q.size();
            int minNum = q.peek().num; // to counter OverFlow of int when multiplying by 2
            int left = 0, ri8 = 0;
            for (int i = 0; i < noOfNodes; i++) {
                TreeNode cur = q.peek().node;
                int id = q.poll().num - minNum;
                if (cur.left != null)
                    q.offer(new Element(cur.left, 2*id + 1));
                if (cur.right != null)
                    q.offer(new Element(cur.right, 2*id + 2));
                if (i == 0) left = id;
                if (i == noOfNodes - 1) ri8 = id;
            }
            maxWid = Math.max(maxWid, ri8 - left + 1);
        }
        return maxWid;
    }
}