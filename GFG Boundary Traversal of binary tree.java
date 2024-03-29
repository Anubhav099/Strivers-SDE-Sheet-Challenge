// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList<Integer> boundary(Node node)
	{
        ArrayList<Integer> left = new ArrayList<>();
        if (node == null) return left;
        if (node.left != node.right) left.add(node.data);
        if (node.left != null) travelLeft(node.left, left);
        travel(node, left);
        if (node.right != null) travelRight(node.right, left, left.size());
        return left; 
    }
    static void travelLeft(Node cur, List<Integer> left) {
        if (cur.left != cur.right) left.add(cur.data);
        if (cur.left != null) travelLeft(cur.left, left);
        else if (cur.right != null) travelLeft(cur.right, left);
    }
    static void travel(Node root, List<Integer> leaf) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            leaf.add(root.data);
        travel(root.left, leaf);
        travel(root.right, leaf);
    }
    static void travelRight(Node cur, List<Integer> right, int index) {
        if (cur.left != cur.right) right.add(index, cur.data);
        if (cur.right != null) travelRight(cur.right, right, index);
        else if (cur.left != null) travelRight(cur.left, right, index);
    }
}