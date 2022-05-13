class DetectSquares:

    def __init__(self):
        self.counter = Counter()

    def add(self, point: List[int]) -> None:
        self.counter[tuple(point)] += 1
        
    def count(self, point: List[int]) -> int:
        x1, y1 = point
        res = 0
        for (x3, y3), cnt in self.counter.items():
            if x1 == x3 or abs(x1 - x3) != abs(y1 - y3):
                continue
            res += cnt * self.counter[(x1, y3)] * self.counter[x3, y1]
        return res
        


# Your DetectSquares object will be instantiated and called as such:
# obj = DetectSquares()
# obj.add(point)
# param_2 = obj.count(point)