/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;

class Pair {
    int level;
    int nodeVal;
    Pair (int level, int nodeVal) {
        this.level = level;
        this.nodeVal = nodeVal;
    }
}
public class Solution {
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.         
        TreeMap<Integer, Pair> map = new TreeMap<>();
        travel(0, 0, root, map);
        List<Integer> ans = new ArrayList<>();
        for (Pair pair: map.values())
            ans.add(pair.nodeVal);
        return ans;
    }
    static void travel(int x, int y, TreeNode cur, TreeMap<Integer, Pair> map) {
        if (cur == null) return;

        if (!map.containsKey(x))
            map.put(x, new Pair(y, cur.val));
        else if(map.get(x).level <= y)
            map.put(x, new Pair(y, cur.val));

        travel(x - 1, y + 1, cur.left, map);
        travel(x + 1, y + 1, cur.right, map);
    }
}
