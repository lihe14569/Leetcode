class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        s = []
        ans = []
        h = 0
        for left, right, height in buildings:
            while s and s[0][0] < left:
                r, rh = heapq.heappop(s)
                if rh == h:
                    rh = max(s, key=lambda val: val[1])[1] if s else 0
                    if rh != h:
                        h = rh
                        ans.append([r, h])
            if height > h:
                h = height
                # 避免左端点重复的问题
                if ans and left == ans[-1][0]:
                    ans[-1][1] = h
                else:
                    ans.append([left, h])
            heapq.heappush(s, [right, height])
        while s:
            r, rh = heapq.heappop(s)
            if rh == h:
                rh = max(s, key=lambda val: val[1])[1] if s else 0
                if rh != h:
                    h = rh
                    ans.append([r, h])
        return ans
