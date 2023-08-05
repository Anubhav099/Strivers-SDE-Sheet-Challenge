class MyQueue {
    Stack<Integer> stk = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        Stack<Integer> dum = new Stack<>();
        while ( !stk.isEmpty() ) {
            dum.push(stk.pop());
        }
        int ret = dum.pop();
        while ( !dum.isEmpty() ) {
            stk.push(dum.pop());
        }
        return ret;
    }
    
    public int peek() {
        Stack<Integer> dum = new Stack<>();
        while ( !stk.isEmpty() ) {
            dum.push(stk.pop());
        }
        int ret = dum.peek();
        while ( !dum.isEmpty() ) {
            stk.push(dum.pop());
        }
        return ret;
    }
    
    public boolean empty() {
        if (stk.size() == 0) return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */