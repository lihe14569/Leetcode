class MyCircularQueue {
    int[] q;
    int head, tail, size, capacity;
    public MyCircularQueue(int k) {
        q = new int[k];
        head= 0;
        tail = -1;
        size = 0;
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(size < capacity) {
            tail = (tail + 1) % capacity;
            q[tail] = value;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(size > 0) {
            head = (head + 1) % capacity;
            size--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(size > 0) return q[head];
        return -1;
    }
    
    public int Rear() {
        if(size > 0) return q[tail];
        return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */