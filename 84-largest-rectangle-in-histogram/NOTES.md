monotonic stack 小技巧： 初始stack之后,push -1，就不用判断stack是否为空了
```
public int largestRectangleArea(int[] heights) {
//dp + monotonic stack
int n = heights.length;
Stack<Integer> stack = new Stack<>();
stack.push(-1);
int area = 0;
for(int i = 0; i < n; i++) {
while(stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
int h = heights[stack.pop()];
int w = i - stack.peek() - 1;
area = Math.max(area, h * w);
}
stack.push(i);
}
while(stack.peek() != -1) {
int h = heights[stack.pop()];
int w = n - stack.peek() - 1;
area = Math.max(area, h * w);
}
return area;
}
```