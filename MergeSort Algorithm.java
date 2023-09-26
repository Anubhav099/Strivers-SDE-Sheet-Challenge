class Solution
{
    void mergeSort(int arr[], int left, int right)
    {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    void merge(int arr[], int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
    
        for (int k = 0; k < temp.length; k++)
            if (i <= mid && (j > right || arr[i] <= arr[j]))
                temp[k] = arr[i++];
            else temp[k] = arr[j++];
    
        for (int k = 0; k < temp.length; k++)
            arr[left + k] = temp[k];
    }
}