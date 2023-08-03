class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low<=high) {
            int mid = low + high >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[low]<=nums[mid]) { // low --> mid is sorted
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else { // mid --> high is sorted
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
// TC: O(log n)