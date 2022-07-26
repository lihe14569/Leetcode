# """
# This is Sea's API interface.
# You should not implement it, or speculate about its implementation
# """
#class Sea:
#    def hasShips(self, topRight: 'Point', bottomLeft: 'Point') -> bool:
#
#class Point:
#	def __init__(self, x: int, y: int):
#		self.x = x
#		self.y = y

class Solution:
    def countShips(self, sea: 'Sea', tr: 'Point', bl: 'Point') -> int:
        if bl.x > tr.x or bl.y > tr.y: return 0
        if not sea.hasShips(tr, bl): return 0
        if bl.x == tr.x and bl.y == tr.y:
            return 1
        midx = (bl.x + tr.x) // 2
        midy = (bl.y + tr.y) // 2
        
        return self.countShips(sea, tr, Point(midx + 1, midy + 1)) + \
               self.countShips(sea, Point(midx, midy), bl) + \
               self.countShips(sea, Point(midx, tr.y), Point(bl.x, midy + 1)) + \
               self.countShips(sea, Point(tr.x, midy), Point(midx + 1, bl.y))