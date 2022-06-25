if negH: heappush(live, (negH, R))
​
java + priority queue + sorted lines
1. 把building拆成【start, -height】 和【end， height】的lines，然后按横坐标（第一个元素）升序排列，如果横坐标相同，按building的高度升序排列*
2. 创建pq,里面存放楼房的高度，按降序排列。初始高度0push进pq.
3. 用preMax来记录之前最高点，遍历所有的building lines.如果是左侧，高度取反加入pq, 如果是右侧，从pq中移除高度。然后判断当前的最大高度currMax，如果和preMax不同，证明发生了高度变化， 发生高度变化说明有数据要加入结果res。
```
class Solution {
public List<List<Integer>> getSkyline(int[][] bs) {
List<int[]> lines = new ArrayList<>();
for(int[] b : bs) {
lines.add(new int[]{b[0], -b[2]});
lines.add(new int[]{b[1], b[2]});
}
Collections.sort(lines, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
pq.offer(0);
int preMax = 0;
List<List<Integer>> res = new ArrayList<>();
for(int[] b : lines) {
if(b[1] < 0)
pq.offer(-b[1]);
else
pq.remove(b[1]);
int currMax = pq.peek();
if(currMax != preMax) {
res.add(List.of(b[0], currMax));
preMax = currMax;
}
}
return res;
}
}
```