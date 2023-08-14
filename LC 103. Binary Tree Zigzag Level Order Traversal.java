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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean rightToLeft = true;
        while (!q.isEmpty()) {
            rightToLeft = !rightToLeft;
            int noOfNodes = q.size();
            reverse(q);
            List<Integer> li = new ArrayList<>();
            while (noOfNodes-- > 0) {
                TreeNode cur = q.poll();
                li.add(cur.val);
                if (!rightToLeft && cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                if (rightToLeft && cur.left != null) q.offer(cur.left);
            }
            ans.add(li);
        }
        return ans;
    }
    void reverse(Queue<TreeNode> q) {
        Stack<TreeNode> stk = new Stack<>();
        while (!q.isEmpty())
            stk.push(q.poll());
        while (!stk.isEmpty())
            q.offer(stk.pop());
    }
}
// This is actual zig-zag traversal of the tree.
// We can use this trick to maintain an ans list which looks like a zigzag traversal at the end:

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            int noOfNodes = q.size();
            List<Integer> li = new ArrayList<>();
            while (noOfNodes-- > 0) {
                TreeNode cur = q.poll();
                li.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            if ((i++) % 2 == 0) Collections.reverse(li); // the only diff compared to usual level order traversal
            ans.add(li);
        }
        return ans;
    }
}