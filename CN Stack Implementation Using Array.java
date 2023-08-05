public class Solution{
    static class Stack {
        int n = 0;
        int[] stk;
        int top = -1;
        Stack(int capacity) {
            // Write your code here.
            n = capacity;
            stk = new int[n];
        }
        public void push(int num) {
            // Write your code here.
            if (top == n - 1) return;
            stk[++top] = num;
        }
        public int pop() {
            // Write your code here.
            if (top == -1 ) return -1;
            return stk[top--];
        }
        public int top() {
            // Write your code here.
            if (top == -1 ) return -1;
            return stk[top];
        }
        public int isEmpty() {
            // Write your code here.
            if (top == -1 ) return 1;
            return 0;
        }
        public int isFull() {
            // Write your code here.
            if (top == n - 1) return 1;
            return 0;
        }
    }
}