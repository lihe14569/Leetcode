思路：the duplicate number will have a count of numbers less than or equal to itself, that is greater than itself .
```
public int findDuplicate(int[] nums) {
int n = nums.length;
int l = 1, r = n - 1;
while( l < r) {
int m = (l + r) /2;
int cnt = 0;
for(int num : nums) {
if(num >= l && num <= m) {
cnt++;
}
}
if(cnt > m - l + 1) r = m;
else l = m + 1;
}
return l;
}
```
​