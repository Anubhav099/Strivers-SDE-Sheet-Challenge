class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
                    // we can also use ((a, b) -> b - a) instead of this ^^
        for (int num: nums) {
            heap.offer(num);
            // offer returns false if the heap is full whereas add throws an exception
        }
        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }
        return heap.peek();
    }
}