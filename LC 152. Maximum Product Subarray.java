// Brute Force
class Solution {
    public int maxProduct(int[] nums) {
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

// Optimal Approach - 1
class Solution {
    public int maxProduct(int[] A) {
        int n = A.length;
        int r = A[0];

        for (int i = 1, imax = r, imin = r; i < n; i++) {
            if (A[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);
            
            r = Math.max(r, imax);
        }
        return r;
    }
}

// Optimal Approach - 2
class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int left = 0, right = nums.length - 1;
        int lMax = 1, rMax = 1;
        while (left <= nums.length - 1) {
            if (lMax == 0) lMax = 1;
            if (rMax == 0) rMax = 1;

            lMax *= nums[left++];
            rMax *= nums[right--];
            
            ans = Math.max(ans, Math.max(lMax, rMax));
        }
        return ans;
    }
}