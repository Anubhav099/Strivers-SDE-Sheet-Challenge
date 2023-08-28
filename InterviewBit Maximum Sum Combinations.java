// Better Solution

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> list1, ArrayList<Integer> list2, int finalSize) {
        if (finalSize == 0) return new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(finalSize);
        minHeap.offer(Integer.MIN_VALUE);
        for (int i = 0; i < list1.size(); i++)
            for (int j = 0; j < list2.size(); j++) {
                int sum = list1.get(i) + list2.get(j);
                if (sum > minHeap.peek()) {
                    if (minHeap.size() == finalSize) minHeap.poll();
                    minHeap.offer(sum);
                }
            }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!minHeap.isEmpty())
            ans.add(minHeap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
// TC: O(n^2), SC: O(2*finalSize)



// Optimal Solution

public class Solution {
    private class Pair{
        int posA, posB, val;
        Pair(int a ,int b , int sum){
            posA = a;
            posB = b;
            val = sum;
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> list1, ArrayList<Integer> list2, int finalSize) {
        int size = list1.size();
        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2, Collections.reverseOrder());
        
        PriorityQueue<Pair> maxHeap= new PriorityQueue<>((a,b)->b.val-a.val);
        Set<Integer> set = new HashSet<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        maxHeap.add(new Pair(0, 0, list1.get(0) + list2.get(0)));
        set.add(0);
        while(finalSize-- > 0){
            Pair cur = maxHeap.poll();
            ans.add(cur.val);
            int a = cur.posA;
            int b = cur.posB;
            
            // we are using the formula (a * size + b) to avoid reduntant storage of objects for every pair of (a,b)
            if(b + 1 < size && !set.contains(a * size + (b + 1))) {
                set.add(a * size + (b + 1));
                maxHeap.add(new Pair(a, b + 1, list1.get(a) + list2.get(b + 1)));
            }
            if(a + 1 < size && !set.contains((a + 1) * size + b)) {
                set.add((a + 1) * size + b);
                maxHeap.add(new Pair(a + 1, b, list1.get(a + 1) + list2.get(b)));
            }
        }
        return ans;
    }
}

// TC: O(nlogn), SC: O(C)