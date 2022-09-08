class HitCounter:

    def __init__(self):
        self.record = defaultdict(int)

    def hit(self, timestamp: int) -> None:
        self.record[timestamp] += 1

    def getHits(self, timestamp: int) -> int:
        prev = timestamp - 299
        if prev < 0: prev = 0
        cnt = 0
        for i in range(prev, timestamp + 1):
            cnt += self.record[i]
        return cnt


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)