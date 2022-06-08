class Solution:
    def removePalindromeSub(self, s: str) -> int:
        if not s:
            return 0
        def ispanlindrome(s):
            l, r=  0, len(s) - 1
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True
        if ispanlindrome(s):
            return 1
        else:
            return 2
    