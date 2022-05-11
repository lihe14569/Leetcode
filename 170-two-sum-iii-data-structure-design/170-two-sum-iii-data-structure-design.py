class TwoSum:

    def __init__(self):
        self.dic= defaultdict(int)

    def add(self, number: int) -> None:
        self.dic[number] += 1

    def find(self, value: int) -> bool:
        for num in self.dic.keys():
            comple = value - num
            if comple != num:
                if comple in self.dic:
                    return True
            elif self.dic[num] > 1:
                return True
        return False
            


# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)