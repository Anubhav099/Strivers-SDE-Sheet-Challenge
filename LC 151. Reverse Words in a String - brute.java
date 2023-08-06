class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+"); // to split into arr with no empty stirngs
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            String temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
        System.out.println(Arrays.toString(arr));
        return String.join(" ",arr);
    }
}