class Solution
{
    static void quickSort(int arr[], int low, int high)
    {
        if (low >= high) return;
        int pivot = arr[high];
        
        int left = low, right = high;
        while (left < right) {
            while (left < right && arr[left] <= pivot)
                left++;
            while (left < right && arr[right] >= pivot)
                right--;
            
            swap(arr, left, right);
        }
        swap(arr, left, high);
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }
    static void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
}




// better for interview:
class Solution
{
    void quickSort(int arr[], int low, int high)
    {
        if (low >= high) return;
        
        int pivot = arr[high];
        int left = partition(arr, low, high, pivot);
        
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }
    
    int partition(int arr[], int low, int high, int pivot) {
        int left = low, right = high;
        while (left < right) {
            while (left < right && arr[left] <= pivot)
                left++;
            while (left < right && arr[right] >= pivot)
                right--;
            
            swap(arr, left, right);
        }
        swap(arr, left, high);
        return left;
    }
    
    void swap(int[] arr, int ind1, int ind2) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }
}