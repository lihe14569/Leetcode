**Solution1: Two stack**
​
* stack1 来存所有的数
* stack2： minStack来存当前最小的数
​
```
//two stack method
Stack<Integer> stack;
Stack<Integer> minStack;
public MinStack() {
stack = new Stack<>();
minStack = new Stack<>();
}
public void push(int val) {
stack.push(val);
if(minStack.isEmpty() || val <= minStack.peek())
minStack.push(val);
}
public void pop() {
int val = stack.pop();
if(val == minStack.peek())
minStack.pop();
}