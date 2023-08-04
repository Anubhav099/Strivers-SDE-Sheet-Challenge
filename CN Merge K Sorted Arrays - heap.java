import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (ArrayList li: kArrays) {
			heap.addAll(li);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		while(!heap.isEmpty()) {
			ans.add(heap.poll());
		}
		return ans;
	}
}
