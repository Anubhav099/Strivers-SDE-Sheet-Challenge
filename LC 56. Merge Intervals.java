class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        int[] toBeAdded = intervals[0];

        for (int[] cur: intervals) {
            if (cur[0] <= toBeAdded[1]) {
                toBeAdded[1] = Math.max(toBeAdded[1], cur[1]);
            } else if (toBeAdded[1] < cur[1]) {
                res.add(toBeAdded);
                toBeAdded = cur;
            }
        }
        res.add(toBeAdded);
        return res.toArray(new int[res.size()][]);
    }
}