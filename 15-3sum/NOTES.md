two pointer O(N^2)
```
public List<List<Integer>> threeSum(int[] nums) {
//two pointer
List<List<Integer>> res = new ArrayList<>();
Arrays.sort(nums); //注意two pointer的适用前提是有序数组
int n = nums.length;
for(int i = 0; i < n - 2; i++) {
if(i != 0 && nums[i] == nums[i - 1]) continue;
int left = i + 1, right = n - 1;
twoSum(res, nums, left, right, i);
}
return res;
}
public void twoSum(List<List<Integer>> res, int[] nums, int l, int r, int i) {
while(l < r) {
int sum = nums[l] + nums[r] + nums[i];
if(sum == 0) {
res.add(Arrays.asList(nums[i], nums[l], nums[r]));
l++;
r--;
while(l < r && nums[l] == nums[l - 1]) l++;
while(l < r && nums[r] == nums[r + 1]) r--;
} else if(sum < 0) l++;
else r--;
}
}
```