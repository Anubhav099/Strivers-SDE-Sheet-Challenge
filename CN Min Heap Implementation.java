/*
    Time complexity: O( N * log( N ))
    Space complexity: O( N )

    Where 'N' is the number of queries..
*/
public class Solution {

    static class MinHeap {
        private int capacity;
        private int heapSize;
        private int[] heapArray;

        // Constructor to initialize the heap.
        MinHeap(int size) {
            heapSize = 0;
            capacity = size;
            heapArray = new int[capacity];
        }

        // Function to get the index of the parent node.
        int parent(int i) {
            return (i - 1) / 2;
        }

        // Function to get the index of the left child node.
        int left(int i) {
            return 2 * i + 1;
        }

        // Function to get the index of the right child node.
        int right(int i) {
            return 2 * i + 2;
        }

        // Extract the minimum element from the heap.
        int extractMinElement() {
            if (heapSize <= 0) {
                // Indicate that the heap is empty.
                return -1;
            }
            if (heapSize == 1) {
                heapSize--;
                // Return the only element in the heap.
                return heapArray[0];
            }

            // Store the root element.
            int root = heapArray[0];

            heapSize--;
            heapArray[0] = heapArray[heapSize];
            heapArray[heapSize] = 0;

            // Restore the heap property.
            heapify(0);

            return root;
        }

        // Delete an element at a given index.
        void deleteElement(int ind) {
            if (ind < heapSize) {
                // Decrease the key to the minimum possible value.
                decreaseKeyElement(ind, Integer.MIN_VALUE);

                // Remove the element from the heap.
                extractMinElement();
            }
        }

        // Insert a new element into the heap.
        void insert(int val) {
            int ind = heapSize;
            heapSize++;
            heapArray[ind] = val;

            // Restore the heap property by swapping with parent if necessary.
            while (ind != 0 && heapArray[ind] < heapArray[parent(ind)]) {
                swap(ind, parent(ind));
                ind = parent(ind);
            }
        }

        // Delete an element at a given index by decreasing its key to Integer.MIN_VALUE.
        void deleteKey(int ind) {
            if (ind < heapSize) {
                // Decrease the key to the minimum possible value.
                decreaseKeyElement(ind, Integer.MIN_VALUE);

                // Remove the element from the heap.
                extractMinElement();
            }
        }

        // Decrease the value of an element at a given index.
        void decreaseKeyElement(int ind, int new_val) {
            // Update the element's value.
            heapArray[ind] = new_val;
            while (ind != 0 && heapArray[parent(ind)] > heapArray[ind]) {
                // Swap with parent if violating heap property.
                swap(ind, parent(ind));
                ind = parent(ind);
            }
        }

        // Heapify the heap from a given index.
        void heapify(int ind) {
            int l = left(ind);
            int r = right(ind);
            int smallest = ind;

            // Find the index of the smallest element among current node, left child, and right child.
            if (l < heapSize && heapArray[l] < heapArray[smallest])
                smallest = l;
            if (r < heapSize && heapArray[r] < heapArray[smallest])
                smallest = r;

            // If the smallest element is not the current node, swap and recursively heapify.
            if (smallest != ind) {
                swap(ind, smallest);
                heapify(smallest);
            }
        }

        // Helper method to swap two elements in the heapArray.
        void swap(int i, int j) {
            int temp = heapArray[i];
            heapArray[i] = heapArray[j];
            heapArray[j] = temp;
        }
    }

};