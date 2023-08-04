class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(map.size(), (a,b) -> map.get(b) - map.get(a));
        // for (Map.Entry m: map.entrySet())
        //     heap.offer((int)m.getKey());
        heap.addAll(map.keySet());

        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = heap.poll();
        return ans;
    }
}