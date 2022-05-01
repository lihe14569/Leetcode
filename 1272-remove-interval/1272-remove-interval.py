class Solution:
    def removeInterval(self, intervals: List[List[int]], toBeRemoved: List[int]) -> List[List[int]]:
        res = []
        for curr in intervals:
            if curr[1] < toBeRemoved[0] or curr[0] > toBeRemoved[1]:
                res.append(curr)
            else:
                if curr[0] < toBeRemoved[0]:
                    res.append([curr[0], toBeRemoved[0]])
                if curr[1] > toBeRemoved[1]:
                    res.append([toBeRemoved[1], curr[1]])
        return res
                    
                    