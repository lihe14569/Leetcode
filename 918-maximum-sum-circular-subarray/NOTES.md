method1;
```
public int maxSubarraySumCircular(int[] nums) {
int currMax = 0, totalMax = nums[0], currMin = 0, totalMin = nums[0];
int sum = 0;
for(int num : nums) {
currMax = Math.max(currMax + num, num);
totalMax = Math.max(totalMax, currMax);
currMin = Math.min(currMin + num, num);
totalMin = Math.min(totalMin, currMin);
sum += num;
}
return totalMax < 0 ? totalMax : Math.max(totalMax, sum - totalMin);
}
```