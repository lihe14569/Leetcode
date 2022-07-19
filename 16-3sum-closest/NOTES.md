sort + two pointer
```
public int threeSumClosest(int[] nums, int target) {
Arrays.sort(nums);
int n = nums.length;
//注意：res为一个有效的数值
int[] res = new int[]{nums[0] + nums[1] + nums[2]};
//遍历每一个点做为第三个数
for(int i = 0; i < n; i++) {
int l = i + 1, r = n - 1;
twoSum(nums, i, l , r, target, res);
}
return res[0];
}
​
private void twoSum(int[] nums, int i, int l, int r, int target, int[] res) {
while(l < r) {
int sum = nums[i] + nums[l] + nums[r];
if(Math.abs(sum - target) < Math.abs(res[0] - target)) {
res[0] = sum;
}
if(sum > target) r--;
else l++;
}
}