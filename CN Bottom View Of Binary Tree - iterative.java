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

public class Solution {
    public static class Element {
        int hd = 0;
        TreeNode node;
        Element(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.         
        if (root == null) return new ArrayList<>();
        Queue<Element> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.offer(new Element(0, root));

        while (!q.isEmpty()) {
            Element e = q.poll();
            int hd = e.hd;
            TreeNode cur = e.node;
            
            map.put(hd, cur.val);
            
            if (cur.left != null) q.offer(new Element(hd - 1, cur.left));
            if (cur.right != null) q.offer(new Element(hd + 1, cur.right));
        }
        List<Integer> ans = new ArrayList<>(map.values());
        return ans;
    }
}
// This uses a level order traversal so, for each horizontal distance the val in map will be the last updated values ie the last level at each hd. (No need to take in count the vertical height at the latest value will always have a greater height).