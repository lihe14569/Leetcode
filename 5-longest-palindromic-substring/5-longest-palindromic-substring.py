class Solution:
    def longestPalindrome(self, s: str) -> str:
        #中心扩散
        res = 0
        left, right = 0, 0
        for i in range(len(s)):
            def find(s, l, r):
                while(l >= 0 and r < len(s) and s[l] == s[r]):
                    l -= 1
                    r += 1
                return r - l - 1
            ol = find(s, i, i)
            el = find(s, i, i + 1)
            ml = max(ol, el)
            if ml  > res:
                res = ml
                left =  i - (ml - 1) // 2
                right = i + (ml) // 2
                
        return s[left: right + 1]