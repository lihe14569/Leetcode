Solution: 注意唯一的corner case!! insertfront之后，如果size== 1， update tail = head.
因为初始tail 为-1,如果只call了一次insertFront, front是 q.length - 1, tail 还是-1，当再call getRear()是会报 **ArrayIndexOutOfBoundException()**;
​
```
class MyCircularDeque {
int[] q;
int size;
int head, tail;
public MyCircularDeque(int k) {
q = new int[k];
size = 0;
head = 0;
tail = -1;
}
public boolean insertFront(int value) {
if(!isFull()) {
head = head == 0 ? q.length - 1 : (head - 1) % q.length;
q[head] = value;
size++;
if(size == 1) tail = head;// corner case
return true;
}
return false;
}
public boolean insertLast(int value) {
if(!isFull()) {
tail = (tail + 1) % q.length;
q[tail] = value;
size++;
return true;
}
return false;
}
public boolean deleteFront() {
if(!isEmpty()) {
head = (head + 1) % q.length;
size--;
return true;
}
return false;
}
public boolean deleteLast() {
if(!isEmpty()) {
tail = tail == 0 ? q.length - 1 : (tail - 1) % q.length;
size--;
return true;