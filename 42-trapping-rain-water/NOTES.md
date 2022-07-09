int res = 0;
while(l < r) {
if(height[l] < height[r]) {
if(height[l] < lmax) res += lmax - height[l];
else lmax = height[l];
l++;
} else {
if(height[r] < rmax) res += rmax - height[r];
else rmax = height[r];
r--;
}
}
return res;
}
}
```
# 方法三：单调栈
```
public int trap(int[] height) {
//two pointer
int res = 0;
Stack<Integer> stack = new Stack<>();
for(int i = 0; i < height.length; i++) {
while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
int l = stack.pop();
//如果到了最左边，没有左边界，不能蓄水，跳出循环
if(stack.isEmpty()) break;
//低点的左右两边，取最小最为蓄水墙高度
int h = Math.min(height[i], height[stack.peek()]);
//蓄水宽度是左右墙的距离- 2，去掉两个墙
int width = i - stack.peek() - 1;
res += width * (h  - height[l]);
}
stack.push(i);
}
return res;
}
```
​