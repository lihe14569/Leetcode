```
public long minimalKSum(int[] nums, int k) {
Arrays.sort(nums);
long sum = 0;
int prev = -1;
for(int num: nums){
if(prev == num) continue;
if (num > k) break;
k++;
sum += num;
prev = num;
}
return (long)(1+k)*k/2-sum;
}
```