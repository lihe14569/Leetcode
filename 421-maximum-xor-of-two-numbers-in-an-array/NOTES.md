bitwise operation + hashset
```
public int findMaximumXOR(int[] nums) {
//bitwise + hashset
int n = nums.length;
int max = 0;
for(int num : nums) max = Math.max(max, num);
//记住java method
int len = (Integer.toBinaryString(max).length());
int maxXor = 0, currXor = 0;
for(int i = len - 1; i >= 0; i--) {
maxXor <<= 1;
Set<Integer> prefix = new HashSet<>();
currXor = maxXor | 1;
for(int num : nums) prefix.add(num >> i);
for(int p : prefix) {//注意：要从处理过的prefix选
//不需要担心p ^ p, 因为xor 相同最后是最小，不可能是currXor
if(prefix.contains(currXor^p)) {
maxXor = currXor;
break;
}
}
}
return maxXor;
}
```