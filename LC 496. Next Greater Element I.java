class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int[] seq = new int[nums2.length];
        Stack<Integer> stk = new Stack<>();
        calc(stk, nums2, seq);

        stk = null;
        for (int k = 0, i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++)
                if (nums1[i] == nums2[j])
                    ans[k++] = seq[j];
        System.gc();
        return ans;
    }
    public void calc( Stack<Integer> stk, int[] nums2, int[] seq){
        for (int k = nums2.length - 1, i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while ( !stk.isEmpty() && stk.peek() < num ) {
                stk.pop();
            }
            if (!stk.isEmpty()) seq[k--] = stk.peek();
            else seq[k--] = -1;
            stk.push(num);
            // System.out.println(stk+"\t"+Arrays.toString(seq));
        }
    }
}