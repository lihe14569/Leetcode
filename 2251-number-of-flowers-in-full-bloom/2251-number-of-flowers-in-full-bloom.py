import bisect
class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], persons: List[int]) -> List[int]:
        res = []
        start= []
        end = []
        
        for f in flowers:
            start.append(f[0])
            end.append(f[1])
        start.sort()
        end.sort()
        
        for p in persons:
            idx1 = bisect.bisect_right(start, p)
            idx2 = bisect.bisect_left(end, p)
            res.append(idx1 - idx2)
        
        return res