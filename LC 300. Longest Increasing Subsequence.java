// DP using a map
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxi = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curNum = nums[i];

            int curMax = 0;
            for (Map.Entry<Integer, Integer> m: map.entrySet()) {
                if (m.getKey() > curNum) curMax = Math.max(curMax, m.getValue());
            }
            curMax++;
            
            map.put(curNum, curMax);
            maxi = Math.max(maxi, curMax);
        }

        return maxi;
    }
}



// 2D memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row: dp) Arrays.fill(row, -1);
        return dfs(0, n, nums, dp);
    }
    int dfs(int cur, int prev, int[] nums, int[][] dp) {
        if (cur == nums.length) return 0;
        if (dp[cur][prev] != -1) return dp[cur][prev];
        
        int pick = 0;
        if (prev == nums.length || nums[prev] < nums[cur])
            pick = 1 + dfs(cur + 1, cur, nums, dp);
        int notPick = dfs(cur + 1, prev, nums, dp);

        return dp[cur][prev] = Math.max(pick, notPick);
    }
}



// 1D memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(0, -1, nums, dp);
    }
    int dfs(int cur, int prev, int[] nums, int[] dp) {
        if (cur == nums.length) return 0;
        if (dp[prev + 1] != -1) return dp[prev + 1];
        
        int pick = 0;
        if (prev == -1 || nums[prev] < nums[cur])
            pick = 1 + dfs(cur + 1, cur, nums, dp);
        int notPick = dfs(cur + 1, prev, nums, dp);

        return dp[prev + 1] = Math.max(pick, notPick);
    }
}



// Tabulation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int ans = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}



// Binary Search
int LISWithBS(int[] nums){
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(list.isEmpty() || list.get(list.size()-1) < nums[i])
                list.add(nums[i]);
            else{
                list.set(binSearch(list,nums[i]),nums[i]);
            }
        }
        
        return list.size();
    }
    
    
    int binSearch(List<Integer> list, int num){
        int start =0, end = list.size();
        int index = 0;
        while(start <= end){
            int mid = (start+end)/2;
            if(list.get(mid) == num)
                return mid;
            else if(list.get(mid) < num){
                start = mid+1;
            }else{
                index = mid;
                end =  mid-1;
            }
        }
        return index;
    }
}
