class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        def left(arr):
            larr = [arr[0]] + [0]* (len(arr) - 1)
            for i in range(1, len(arr)):
                larr[i] = max(larr[i- 1] - 1, arr[i])
            return larr
        
        def right(arr):
            n = len(arr)
            rarr =  [0]* (n - 1) + [arr[n - 1]]
            for i in range(len(arr) -2, -1, -1):
                rarr[i] = max(rarr[i+ 1] - 1, arr[i])
            return rarr
        
        prev= points[0]
        for i in range(1, len(points)):
            larr, rarr = left(prev), right(prev)
            curr= len(prev) * [0]
            for j in range(len(prev)):
                curr[j] = points[i][j] + max(larr[j], rarr[j])
            prev = curr[:]
        return max(prev)
        