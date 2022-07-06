class MinStack {
    Deque<Integer> stack;
    Deque<Integer> mins;
    int min;
    public MinStack() {
        stack = new ArrayDeque<>();
        mins = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        if(val < min)
            min = val;
        mins.push(min);
    }
    
    public void pop() {
        stack.pop();
        mins.pop();
        min = mins.isEmpty() ? Integer.MAX_VALUE : mins.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */