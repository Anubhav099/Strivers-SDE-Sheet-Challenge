import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public  static int findCeil(TreeNode<Integer> root, int x) {

        // Write your code here
        int ans = -1;
        while (root != null) {
            int val = root.data;
            if (val == x) return x;
            else if (val < x) root = root.right;
            else {
                root = root.left;
                ans = val;
            }
        }
        return ans;
    }
}
