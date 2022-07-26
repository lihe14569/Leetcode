from random import choice
class RandomizedSet:

    def __init__(self):
        self.dict = {}
        self.lst = []

    def insert(self, val: int) -> bool:
        if val in self.dict:
            return False
        self.dict[val] = len(self.lst)
        self.lst.append(val)
        return True
        

    def remove(self, val: int) -> bool:
        if val in self.dict:
            lst_val = self.lst[-1]
            val_idx = self.dict[val]
            self.lst[val_idx] = lst_val
            self.dict[lst_val] = val_idx
            self.lst.pop()
            del self.dict[val]
            return True
        return False

    def getRandom(self) -> int:
        return choice(self.lst)


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()