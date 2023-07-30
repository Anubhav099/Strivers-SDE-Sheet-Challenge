class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPerm( 0, nums, ans, new ArrayList<>() );
        return ans;
    }

    void findPerm( int ind, int[] nums, List<List<Integer>> ans, List<Integer> ds ) {
        if( ind == nums.length )
            ans.add(new ArrayList<>(ds));
        for( int i = ind; i < nums.length; i++ ) {
            int temp = nums[i];
            nums[i] = nums[ind];
            nums[ind] = temp;
            ds.add(nums[ind]);
            findPerm( ind+1, nums, ans, ds );
            ds.remove( ds.size() - 1 );
            nums[ind] = nums[i];
            nums[i] = temp;
        }
    }
}
// TC: O( n! * n ), SC: O( n )