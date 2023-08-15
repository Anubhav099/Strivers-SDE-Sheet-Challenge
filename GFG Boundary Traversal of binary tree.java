//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

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