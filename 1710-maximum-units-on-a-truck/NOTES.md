coutn sort O(N)
```
class Solution {
public int maximumUnits(int[][] boxTypes, int truckSize) {
int[] arr = new int[1001];
for (int[] box : boxTypes) {
int value = box[1];
arr[value] += box[0];
}
int sum = 0;
for (int i = 1000; i >= 0; i--) {
if (arr[i] == 0) continue;
if (arr[i] > truckSize) {
sum += truckSize * i;
break;
}
truckSize -= arr[i];
sum += arr[i] * i;
}
return sum;
}
}
```