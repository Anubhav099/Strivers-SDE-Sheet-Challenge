class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        
        Arrays.sort(arr);
        
        int min, max, ans = arr[n - 1] - arr[0];
        int downNMinus1 = arr[n - 1] - k, upOf0 = arr[0] + k;
        
        for (int i = 0; i < n - 1; i++) {
            int curDown = arr[i + 1] - k;
            int curUp = arr[i] + k;
            if (curDown < 0) continue;
            min = Math.min(upOf0, curDown);
            max = Math.max(curUp, downNMinus1);
            
            ans = Math.min(ans, max - min);
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(up));
        // System.out.println(Arrays.toString(down));
        return ans;
    }
}