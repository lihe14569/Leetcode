class MyStack:

    def __init__(self):
        self.q1 = deque()

    def push(self, x: int) -> None:
        self.q1.append(x)
        
    def pop(self) -> int:
        for i in range(len(self.q1) - 1):
            self.q1.append(self.q1.popleft())
        return self.q1.popleft()

    def top(self) -> int:
        for i in range(len(self.q1) - 1):
            self.q1.append(self.q1.popleft())
        res = self.q1[0]
        self.q1.append(self.q1.popleft())
        return res

    def empty(self) -> bool:
        return not self.q1


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()