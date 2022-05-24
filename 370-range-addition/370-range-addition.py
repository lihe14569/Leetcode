class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        diff = [0] * length

        
        for u in updates:
            i, j, val = u
            diff[i] += val
            if j + 1 < length:
                diff[j + 1] -= val
        
        
        for i in range(1, length):
            diff[i] += diff[i - 1]
        return diff
                