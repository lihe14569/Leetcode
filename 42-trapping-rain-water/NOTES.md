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
python 单调栈解法
```
def trap(self, height: List[int]) -> int:
res, stack = 0, []
for i in range(len(height)):
while stack and height[i] > height[stack[-1]]:
l = stack.pop()
if not stack:
break
h = min(height[i], height[stack[-1]])
res += (i - stack[-1] - 1) * (h - height[l])
stack.append(i)
return res
```
​
​