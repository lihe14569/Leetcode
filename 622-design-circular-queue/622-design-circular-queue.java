class MyCircularQueue {
    int[] q;
    int hh, tt;
    int size, n;
    public MyCircularQueue(int k) {
        q = new int[k];
        hh = 0;
        tt = -1;
        size = 0;
        n = k;
    }
    
    public boolean enQueue(int value) {
        if(size < n) {
            tt = (tt + 1) % n;
            q[tt] = value;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(size > 0) {
            hh = (hh + 1) % n;
            size--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(size > 0) return q[hh];
        return -1;
    }
    
    public int Rear() {
        if(size > 0) return q[tt];
        return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == n;
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