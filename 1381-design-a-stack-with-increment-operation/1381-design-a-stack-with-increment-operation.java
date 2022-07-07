class CustomStack {
    Stack<Integer> stack;
    int[] diff;
    int n;
    public CustomStack(int maxSize) {
        n = maxSize;
        stack = new Stack<>();
        diff = new int[n];
    }
    
    public void push(int x) {
        if(stack.size() < n)
            stack.push(x);
    }
    
    public int pop() {
        int i = stack.size() - 1;
        if(i < 0) return -1;
        int res = stack.pop() + diff[i];
        if(i -1 >= 0) diff[i - 1]+= diff[i];
        diff[i] = 0;
        return res;
    }
    
    public void increment(int k, int val) {
        int i = Math.min(k -1, stack.size() - 1);
        if(i >= 0) diff[i] += val;
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */