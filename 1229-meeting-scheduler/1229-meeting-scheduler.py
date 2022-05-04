class Solution:
    def minAvailableDuration(self, slots1: List[List[int]], slots2: List[List[int]], duration: int) -> List[int]:
        slots1.sort(key=lambda x:x[0])
        slots2.sort(key=lambda x:x[0])
        m,n = len(slots1), len(slots2)
        
        p1, p2 = 0, 0
        while p1 < m and p2 < n:
            s1, s2 = slots1[p1], slots2[p2]
            l = max(s1[0], s2[0])
            r = min(s1[1], s2[1])
            if r - l >= duration:
                return [l, l + duration]
            else:
                #move smaller interval to next one
                if s1[1] < s2[1]:
                    p1 += 1
                else:
                    p2 +=1
        return []