/********************************************************************

 Following is the class structure of the Node class:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;

     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 };

 ********************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<String> ans = new ArrayList<>();
        travel(root, ans, new ArrayList<>());
        return ans;
    }
    static void travel(BinaryTreeNode cur, List<String> ans, List<Integer> ds) {
        if (cur == null) return;
        ds.add(cur.data);
        if (cur.left == null && cur.right == null) {
            String s = ds.stream()
                         .map(Object::toString) // Convert integers to strings
                         .collect(Collectors.joining(" "));
            ans.add(s);
        }
        travel(cur.left, ans, ds);
        travel(cur.right, ans, ds);
        ds.remove(ds.size() - 1);
    }
}