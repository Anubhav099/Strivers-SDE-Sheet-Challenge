public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        travel( 0, root, ans);
        return ans;
    }

    static void travel(int level, TreeNode<Integer> cur, ArrayList<Integer> ans) {
        if (cur == null) return;
        if (level >= ans.size()) {
            ans.add(cur.data);
        }
        travel(level + 1, cur.left, ans);
        travel(level + 1, cur.right, ans);
    }
}