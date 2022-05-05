method1: sliding window
```
def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
dic = defaultdict(int)
l, n, res = 0, len(s), 0
for i in range(n):
c1 = s[i]
dic[c1] += 1
while len(dic) > k:
c2 = s[l]
dic[c2] -= 1
l += 1
if dic[c2] == 0:
dic.pop(c2)
res = max(res, i - l + 1)
return res
```
​
follow-up: data stream long string
```
def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
if k == 0: return 0
i, max_len, index_map = 0, 0, collections.OrderedDict()
for j, c in enumerate(s):
index_map[c] = j
index_map.move_to_end(c)
if len(index_map) > k:
_, i = index_map.popitem(last=False)
i += 1
max_len = max(max_len, j - i + 1)
return max_len
```