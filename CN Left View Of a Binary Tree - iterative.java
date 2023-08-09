public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int noOfNodesAtThisLevel = q.size();
            ans.add(q.peek().data);
            while (noOfNodesAtThisLevel-- > 0) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                q.remove();
            }
        }
        return ans;
    }
}