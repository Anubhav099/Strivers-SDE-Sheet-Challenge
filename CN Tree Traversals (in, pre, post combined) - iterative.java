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
class Element {
    BinaryTreeNode<Integer> node;
    int num;
    Element(BinaryTreeNode<Integer> node, int num) {
        this.node = node;
        this.num = num;
    }
}
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        if (root == null) return new ArrayList<>();
        Stack<Element> stk = new Stack<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        stk.push(new Element(root, 1));
        while (!stk.isEmpty()) {
            Element e = stk.pop();
            BinaryTreeNode<Integer> cur = e.node;
            int num = e.num;
            
            if (num == 1) {
                pre.add(cur.data);
                stk.push(new Element(cur, 2));
                if (cur.left != null) stk.push(new Element(cur.left, 1));
            }
            else if (num == 2) {
                in.add(cur.data);
                stk.push(new Element(cur, 3));
                if (cur.right != null) stk.push(new Element(cur.right, 1));
            }
            else if (num == 3){
                post.add(cur.data);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;        
    }
}