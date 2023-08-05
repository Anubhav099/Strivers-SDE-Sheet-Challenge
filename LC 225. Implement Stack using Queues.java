class MyStack {
    Queue<Integer> q = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        Queue<Integer> dum = new LinkedList<>();
        while (q.size()>1) {
            dum.add(q.poll());
        }
        int ret = q.peek();
        q = dum;
        return ret;
    }
    
    public int top() {
        Queue<Integer> dum = new LinkedList<>();
        while (q.size()>1) {
            dum.add(q.poll());
        }
        int ret = q.peek();
        dum.add(q.poll());
        q = dum;
        return ret;
    }
    
    public boolean empty() {
        if (q.size() == 0) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */