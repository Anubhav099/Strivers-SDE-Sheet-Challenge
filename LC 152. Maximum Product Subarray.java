class Solution {
    public int maxProduct(int[] nums) {
        // Brute Force
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i  nums.length; i++) {
            int prod = 1, curmax = Integer.MIN_VALUE;
            for (int j = i; j  nums.length; j++) {
                prod = nums[j];
                curmax = Math.max(curmax, prod);
            }
            ans = Math.max(ans, curmax);
        }
        return ans;
    }
}