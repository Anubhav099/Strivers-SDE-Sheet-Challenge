import java.util.* ;
import java.io.*; 

public class Solution {

    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i=0; i < n; i++) {
            if (q[i][0] == 1) {
                ans.add(heap.poll());
            }
            else {
                heap.add(q[i][1]);
            }
        }
        int[] arr = new int[ans.size()];
        int k = 0;
        for (Integer i: ans) {
            arr[k++] = i;
        }
        return arr;
    }
}