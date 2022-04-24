class UndergroundSystem:

    def __init__(self):
        self.ids = {}
        self.time = defaultdict(int)
        self.freq = defaultdict(int)

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.ids[id] =(stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        start, t1 = self.ids.pop(id)
        self.time[(start, stationName)] += t - t1
        self.freq[(start, stationName)] += 1

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        return self.time[(startStation, endStation)] / self.freq[(startStation, endStation)]


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)