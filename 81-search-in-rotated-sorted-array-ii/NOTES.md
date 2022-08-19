solution：
```
class Solution {
public boolean search(int[] nums, int target) {
//预处理：移除右端于最左端相同的点
//1.找到初始点
//2.判断在哪一段
if(nums == null || nums.length == 0) return false;
int R = nums.length - 1;
while(R >= 0 && nums[R] == nums[0]) R--;
if(R < 0) return nums[0] == target;
int l = 0, r = R;
while(l < r) {
int m = l + (r - l + 1) / 2;
if(nums[m] >= nums[0]) l = m;
else r = m - 1;
}
System.out.println(l);
if(target >= nums[0]) {
r = l;
l = 0;
} else {
l++;//corner case:数组递增数组，l++会越界
r = R;
}
while(l < r) {
int m = l + (r - l) / 2;
if(nums[m] >= target) r = m;
else l = m + 1;
}
return nums[r] == target; //返回的是r,因为l可能越界
}
}
```