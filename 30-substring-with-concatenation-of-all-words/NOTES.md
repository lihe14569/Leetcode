sol1
```
class Solution {
public List<Integer> findSubstring(String s, String[] words) {
int m = s.length(), n = words.length, w = words[0].length();
Map<String, Integer> tot = new HashMap<>();
for(String word : words) tot.put(w, tot.getOrDefault(word, 0) + 1);
List<Integer> res = new ArrayList<>();
for(int i = 0; i < k; i++) {
Map<String, Integer> window = new HashMap<>();
int cnt = 0;
for(int j = 0; j + w <= n; j += w) {
}
}
}
}
```