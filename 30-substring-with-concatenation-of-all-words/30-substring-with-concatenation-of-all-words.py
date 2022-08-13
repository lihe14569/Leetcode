class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        l, n, w = len(s), len(words), len(words[0])
        counter = Counter(words)
        
        res = []
        for i in range(w):
            window = defaultdict(int)
            cnt = 0
            for j in range(i, l - w + 1, w):
                if j - i >= n * w:
                    left = s[j - n * w : j - (n - 1) * w]
                    window[left] -= 1
                    if window[left] < counter[left]:
                        cnt -= 1
                right = s[j : j + w]
                window[right] += 1
                if window[right] <= counter[right]:
                    cnt += 1
                if cnt == n:
                    res.append(j - (n - 1) * w)
        return res