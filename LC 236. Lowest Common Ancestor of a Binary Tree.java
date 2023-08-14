// Approach 1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            boolean[] arr = new boolean[2];
            doesExist(root.left, p , q, arr); 
            if (arr[0] && arr[1]) {
                root = root.left;
                continue;
            }
            arr[0] = false; arr[1] = false;
            doesExist(root.right, p, q, arr);
            if (arr[0] && arr[1]) root = root.right;
            else break;
        }
        return root;
    }
    void doesExist(TreeNode cur, TreeNode p, TreeNode q, boolean[] arr) {
        if (cur == null) return;
        
        if (cur == p) arr[0] = true;
        else if (cur == q) arr[1] = true;

        if (arr[0] && arr[1]) return;
        doesExist(cur.left, p, q, arr);
        doesExist(cur.right, p, q, arr);
    }
}

// Approach 2 (Better - worse SC but way better TC)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        travel(root, p , q, pPath, qPath, new ArrayList<>());

        int size = pPath.size() > qPath.size()? qPath.size(): pPath.size();
        for ( int i = 1; i < size; i++)
            if (pPath.get(i) == qPath.get(i))
                if (root.left == pPath.get(i)) root = root.left;
                else root = root.right;
            else break;
            
        return root;
    }
    void travel(TreeNode cur, TreeNode p, TreeNode q, List<TreeNode> pPath, List<TreeNode> qPath, List<TreeNode> ds) {
        if (cur == null) return;

        ds.add(cur);
        if (cur == p) pPath.addAll(ds);
        else if (cur == q) qPath.addAll(ds);

        if (!pPath.isEmpty() && !qPath.isEmpty()) return;
        travel(cur.left, p, q, pPath, qPath, ds);
        travel(cur.right, p, q, pPath, qPath, ds);

        ds.remove(ds.size() - 1);
    }
}

// Approach 3 (Optimal)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;       	// right may or may not be null
        else if (right == null) return left;	// left is definetly not null
        else return root;			// both are not null
    }
}