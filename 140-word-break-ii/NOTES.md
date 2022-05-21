public void getResults(List<Integer>[] dp, String curr, int index, String s, List<String> res) {
res.add(curr.trim());
return;
}
for(int preIndex : dp[index]) {
getResults(dp, s.substring(preIndex, index) + " " + curr, preIndex, s, res);
}
}
```
​
top-down recursive method + memo:
```
def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
memo = defaultdict(list)
word_dic = set(wordDict)
def dfs(word):
if not word:
return [[]]
if word in memo:
return memo[word]
for end in range(1, len(word) + 1):
w = word[:end]
if w in word_dic:
for sentence in dfs(word[end:]):
memo[word].append([w] + sentence)
return memo[word]
dfs(s)
return [ ' '.join(lst) for lst in memo[s]]
```