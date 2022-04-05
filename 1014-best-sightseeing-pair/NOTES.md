method1
每次都更新 values[j] j j;
中间update result
每次循环的最后更新 values[i] + i，下次循环就可以用
```
class Solution {
public int maxScoreSightseeingPair(int[] values) {
int plus = values[0];  //i
int minus = values[1] - 1; //j
int res = plus + minus;
for(int i = 1; i < values.length; i++) {
minus = values[i] - i;
res = Math.max(res, plus + minus);
plus = Math.max(plus, values[i] + i);
}
return res;
}
}
```