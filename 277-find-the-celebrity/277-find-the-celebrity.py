# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        celeb = 0
        for i in range(1, n):
            if knows(celeb, i):
                celeb = i
        if self.checkCeleb(celeb, n):
            return celeb
        else:
            return -1
    def checkCeleb(self, p, n):
        for i in range(n):
            if p == i: continue
            if knows(p, i) or not knows(i, p):
                return False
        return True
                