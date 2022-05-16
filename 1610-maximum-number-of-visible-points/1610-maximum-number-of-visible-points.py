class Solution:
    def visiblePoints(self, points: List[List[int]], angle: int, location: List[int]) -> int:
        res, origin = 0, 0
        xx, yy = location
        rad = []
        for x, y in points:
            if x==xx and y == yy:
                origin += 1
                continue
            rad.append(math.atan2(y - yy, x - xx))
        
        rad.sort()
        #circular
        rad = rad + [x + 2.0 * math.pi for x in rad]
        angle = angle/180 * math.pi
        l = 0
        for i in range(len(rad)):
            while rad[i] - rad[l] > angle:
                l+= 1
            res = max(res, i - l + 1)
        return res + origin