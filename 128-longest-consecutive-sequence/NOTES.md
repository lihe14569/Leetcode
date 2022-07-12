**Solution1: Union-find**
Union  by size, 有parent array 和size array
注意：
* helper function里面 findMax()，遍历一遍dsu的size array,找到size 最大的返回
* Union-find union by size是，check是否在一个group, check的是rootx和rooty是否相等
```
//union-find method
public int longestConsecutive(int[] nums) {
int n = nums.length;
DSU dsu = new DSU(n);
Map<Integer, Integer> map = new HashMap<>();
for(int i = 0; i < n; i++) {
if(map.containsKey(nums[i])) continue;
map.put(nums[i], i);
if(map.containsKey(nums[i] - 1))
dsu.union(i, map.get(nums[i] - 1));
if(map.containsKey(nums[i] + 1))
dsu.union(i, map.get(nums[i] + 1));
}
return dsu.findMax();
}
class DSU {
int[] parent;
int[] size;
public DSU(int n) {
parent = new int[n];