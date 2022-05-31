class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        need = 1 << k
        seen = [False] * need
        all_one = need - 1
        hash_val = 0
        
        for i in range(len(s)):
            hash_val = ((hash_val << 1) & all_one) | int(s[i])
            if i - k + 1 >= 0 and not seen[hash_val]:
                seen[hash_val] = True
                need -= 1
                if need == 0:
                    return True
        return False