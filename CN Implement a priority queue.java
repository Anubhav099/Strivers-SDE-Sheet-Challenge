import java.util.List;
public class Solution {
    public static int pop(List<Integer> heap) {
        // Write you code here.
        if (heap.size() == 0) return -1;
        int maxElem = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        heapify(heap, 0);

        return maxElem;
    }
    static int parent(int ind) {return ind / 2;}
    static int left(int i) {return i * 2 + 1;}
    static int right(int i) {return i * 2 + 2;}
    static void heapify(List<Integer> heap, int ind) {

        int largest = ind;
        int left = left(ind);
        int right = right(ind);
        
        if (left < heap.size() && heap.get(left) > heap.get(largest))
            largest = left;
        if (right < heap.size() && heap.get(right) > heap.get(largest))
            largest = right;
        
        if (largest != ind) {
            swap(heap, ind, largest);
            heapify(heap, largest);
        }
    }
    static void swap(List<Integer> heap, int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Code Snippet of the push function:
    // public static void push(List<Integer> heap, int x) {
    //         heap.add(x);
    //
    //         // Position of the current inserted element.
    //         int pos = heap.size() - 1;
    //
    //         // Shifting the element up until it reaches the topmost node if it is larger than its parent.
    //         while (pos > 0) {
    //             int parent = (pos - 1) / 2;
    //             if (heap.get(pos) > heap.get(parent)) {
    //                 // Swapping the elements.
    //                 int temp = heap.get(parent);
    //                 heap.set(parent, heap.get(pos));
    //                 heap.set(pos, temp);
    //                 pos = parent;
    //             } else {
    //                 // As parent is larger, the element is now in its correct position.
    //                 break;
    //             }
    //         }
    //     }
}
