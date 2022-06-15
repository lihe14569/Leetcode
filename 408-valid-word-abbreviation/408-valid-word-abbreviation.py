class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        i, j = 0, 0
        while i < len(word) and j < len(abbr):
            if word[i] == abbr[j]:
                i += 1
                j += 1
                continue
            if ord(abbr[j]) <= ord('0') or ord(abbr[j]) >= ord('9'):
                return False
            start = j
            while j < len(abbr) and ord(abbr[j]) >= ord('0') and ord(abbr[j]) <= ord('9'):
                j += 1
         
            step = int(abbr[start:j])
            i += step
        return i == len(word) and j == len(abbr)