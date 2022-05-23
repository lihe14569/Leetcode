# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        for i in range(n):
            def isCelebrity(j):
                for k in range(n):
                    if j == k: continue
                    if knows(j, k) or not knows(k, j):
                        return False
                return True
            if isCelebrity(i):
                return i
        return -1