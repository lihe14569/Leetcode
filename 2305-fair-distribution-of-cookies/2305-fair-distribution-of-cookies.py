class Solution:
    def distributeCookies(self, cookies: List[int], k: int) -> int:
        def distribute(start, childs):
            nonlocal res
            if start == len(cookies):
                min_dis = max(childs)
                res = min(res, min_dis)
                return
            if res <= max(childs):
                return
            for i in range(k):
                childs[i] += cookies[start]
                distribute(start +1, childs)
                childs[i] -= cookies[start]
        res = sys.maxsize
        childs = [0]*k
        distribute(0, childs)
        return res
            