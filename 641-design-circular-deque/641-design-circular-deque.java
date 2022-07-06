class MyCircularDeque {
    int[] q;
    int head, tail, size, capacity;
    public MyCircularDeque(int k) {
        q = new int[k];
        head = 0;
        tail = -1;
        size = 0;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(size < capacity) {
            head = (head - 1 + capacity) % capacity;
            q[head] = value;
            size++;
            if(size == 1) tail = head;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if(size < capacity) {
            tail = (tail + 1) % capacity;
            q[tail] = value;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(size > 0) {
            head = (head + 1) % capacity;
            size--;
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if(size > 0) {
            tail = (tail - 1 + capacity) % capacity;
            size--;
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if(size > 0) return q[head];
        return -1;
    }
    
    public int getRear() {
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
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */