class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        res = []
        firstList.sort(key=lambda x:x[0])
        secondList.sort(key=lambda x:x[0])
        m, n, p1, p2 = len(firstList), len(secondList), 0, 0
        
        while p1 < m and p2 < n:
            s1,s2 = firstList[p1], secondList[p2]
            left = max(s1[0], s2[0])
            right = min(s1[1], s2[1])
            if right - left >= 0:
                res.append([left, right])
            if s1[1] < s2[1]:
                p1 +=1
            else:
                p2 +=1
        return res
                