// Brute-Force

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        boolean[] flag = new boolean[]{false};
        dfs(root, set, flag, k);
        return flag[0];
    }
    void dfs(TreeNode cur, Set<Integer> set, boolean[] flag, int k) {
        if (cur == null) return;
        if (set.contains(cur.val)) flag[0] = true;
        set.add(k - cur.val);
        dfs(cur.left, set, flag, k);
        dfs(cur.right, set, flag, k);
    }
}

// Optimal - 1

public class BSTIterator {
    private Stack<TreeNode> stk = new Stack<TreeNode>();
    boolean reverse = true; 
    
    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse; 
        pushAll(root);
    }

    public int next() {
        TreeNode node = stk.pop();
        if (reverse) pushAll(node.left);
        else pushAll(node.right);
        return node.val;
    }
    
    private void pushAll(TreeNode node) {
        while (node != null) {
             stk.push(node);
             if (reverse) node = node.right;
             else node = node.left;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false); 
        BSTIterator right = new BSTIterator(root, true); 
        
        int low = left.next(); 
        int high = right.next(); 
        while (low < high) {
            long sum = low + high;
            if (sum == k) return true; 
            if (sum < k) low = left.next(); 
            else high = right.next(); 
        }
        return false; 
    }
}
// TC: O(n), SC: O(height * 2)

// Optimal - 2: This will perform better on an avg in very large trees where ans is true

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return help(root, root, k);
    }
    boolean help(TreeNode root, TreeNode cur, int k) {
        if (cur == null) return false;
        return find(root, cur, k - cur.val) ||
                help(root, cur.left, k) ||
                help(root, cur.right, k);
    }
    boolean find(TreeNode cur, TreeNode notThis, int key) {
        if (cur == null) return false;
        else if (cur.val == key && cur != notThis) return true;
        return find(cur.val < key? cur.right: cur.left, notThis, key);
    }
}
// TC: O(no. of nodes * height of the tree) , SC: O(1)