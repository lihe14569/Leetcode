quickselect
```
mport java.util.Random;
​
class Solution {
Random rand = new Random();
public int findKthLargest(int[] nums, int k) {
int n = nums.length;
k = n - k;
return quickselect(nums, 0, n - 1, k);
}
public int quickselect(int[] nums, int l, int r, int k) {
if(l == r)
return nums[l];
int position = partition(nums, l, r);
if(position == k)
return nums[k];
else if(position < k) {
return quickselect(nums, position + 1, r, k);
}
else {
return quickselect(nums, l, position - 1, k);
}
}
public int partition(int[] nums, int l, int r) {
int pivotIndex = l + rand.nextInt(r - l + 1);