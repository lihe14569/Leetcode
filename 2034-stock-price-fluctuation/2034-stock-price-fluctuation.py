from sortedcontainers import SortedDict
class StockPrice:
    
    def __init__(self):
        self.time_to_prices = SortedDict()
        self.rec = SortedDict()

    def update(self, timestamp: int, price: int) -> None:
        if timestamp in self.time_to_prices:
            prev_price = self.time_to_prices[timestamp]
            self.rec[prev_price].remove(timestamp)
            if len(self.rec[prev_price]) == 0:
                self.rec.pop(prev_price)
        if  price not in self.rec:
            self.rec[price] = set()
        self.rec[price].add(timestamp)
        self.time_to_prices[timestamp] = price

    def current(self) -> int:
        return self.time_to_prices.peekitem(-1)[1]

    def maximum(self) -> int:
        return self.rec.peekitem(-1)[0]

    def minimum(self) -> int:
        return self.rec.peekitem(0)[0]
        


# Your StockPrice object will be instantiated and called as such:
# obj = StockPrice()
# obj.update(timestamp,price)
# param_2 = obj.current()
# param_3 = obj.maximum()
# param_4 = obj.minimum()