/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;

public class Solution {
    public static class Element {
        int hd;
        TreeNode node;
        Element(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        if (root == null) return new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Element> q = new LinkedList<>();
        q.offer(new Element(0, root));
        while (!q.isEmpty()) {
            Element e = q.poll();
            int hd = e.hd;
            TreeNode cur = e.node;
            if (!map.containsKey(hd))
                map.put(hd, cur.data);
            if (cur.left != null) q.offer(new Element(hd - 1, cur.left));
            if (cur.right != null) q.offer(new Element(hd + 1, cur.right));
            
        }
        return new ArrayList<>(map.values());
    }
}