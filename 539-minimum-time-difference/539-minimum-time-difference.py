class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        def convert(time):
            return int(time[:2]) * 60 + int(time[3:])
        minutes = [convert(t) for t in timePoints]
        minutes.sort()

        return min( (y - x) % (24 * 60) 
                    for x, y in zip(minutes, minutes[1:] + minutes[:1]) )
            