import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
public class Solution {

    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> ans = new ArrayList<>();
    
        // Initialize and add lists
        ans.add(new ArrayList<>());  // In-order
        ans.add(new ArrayList<>());  // Pre-order
        ans.add(new ArrayList<>());  // Post-order
    
        travel(root, ans);
        return ans;
    }

    static void travel(BinaryTreeNode<Integer> cur, List<List<Integer>> ans) {
        if (cur == null) return;
    
        ans.get(1).add(cur.data);  // In-order
        
        travel(cur.left, ans);
    
        ans.get(0).add(cur.data);  // Pre-order
    
        travel(cur.right, ans);
        
        ans.get(2).add(cur.data);  // Post-order
    }
}