class MinStack:

    def __init__(self):
        self.data = []
        self.min = []
        self.curr_min = float('inf')

    def push(self, val: int) -> None:
        self.data.append(val)
        self.curr_min = min(self.curr_min, val)
        self.min.append(self.curr_min)
        

    def pop(self) -> None:
        self.data.pop()
        self.min.pop()
        self.curr_min = self.min[-1] if self.min else sys.maxsize

    def top(self) -> int:
        return self.data[-1]

    def getMin(self) -> int:
        return self.min[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()