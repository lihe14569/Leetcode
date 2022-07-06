Soluiotn: array + head, tail pointer + size
​
```java
class MyCircularQueue {
int[] q;
int size;
int head, tail;
public MyCircularQueue(int k) {
q = new int[k];
size = 0;
head = 0;
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