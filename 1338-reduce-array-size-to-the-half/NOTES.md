my solution without any tips
```
class Solution {
public int minSetSize(int[] arr) {
int n = arr.length;
Map<Integer, Integer> map = new HashMap<>();
for(int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
List<Integer> keys = new ArrayList<>(map.keySet());
Collections.sort(keys, (a, b) -> map.get(a) - map.get(b));
int rest = n;
int cnt = 0;
while(rest > n / 2) {
int k = keys.remove(keys.size() - 1);
rest -= map.get(k);
map.remove(k);
cnt++;
}
return cnt;
}
}
```
​
​