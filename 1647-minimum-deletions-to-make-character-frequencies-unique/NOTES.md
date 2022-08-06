sort，从高频遍历到低频； 定义参数最大允许频率 maxFreq, 初始值为 s.length()
从最大遍历到最小，如果当前的freq 大于maxFreq, 叠加freq和maxFreq的差值，然后更新freq为maxFreq. 然后更新下一个maxFreq因该定义的value
```
class Solution {
public int minDeletions(String s) {
int[] freq = new int[26];
for(char c : s.toCharArray()) {
freq[c - 'a']++;
}
Arrays.sort(freq);
int cnt = 0;
int maxAllowedFreq = s.length();
for(int i = 25; i >= 0 && freq[i] > 0; i--) {
if(freq[i] > maxAllowedFreq) {
cnt += freq[i] - maxAllowedFreq;
freq[i] = maxAllowedFreq;
}
maxAllowedFreq = Math.max(0, freq[i] - 1);
}
return cnt;
}
}
```