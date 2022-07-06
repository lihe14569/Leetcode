class MyStack {
    Queue<Integer> q1, q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        Queue<Integer> temp_q = q1;
        q1 = q2;
        q2 = temp_q;
        return res;
    }
    
    public int top() {
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        q2.offer(res);
        Queue<Integer> temp_q = q1;
        q1 = q2;
        q2 = temp_q;
        return res;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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