class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s= s.strip()
        sarr = s.split(' ')
        return len(sarr[-1])