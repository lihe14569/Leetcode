tail = -1;
}
public boolean enQueue(int value) {
if(!isFull()) {
tail = (tail + 1) % q.length;
q[tail] = value;
size++;
return true;
}
return false;
}
public boolean deQueue() {
if(!isEmpty()) {
head = (head + 1) % q.length;
size--;
return true;
}
return false;
}
public int Front() {
return isEmpty() ? -1 : q[head];
}
public int Rear() {
return isEmpty() ? -1 : q[tail];
}
public boolean isEmpty() {
return size == 0;
}
public boolean isFull() {
return size == q.length;
}
}
​
​
```