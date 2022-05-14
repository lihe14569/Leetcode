class SnapshotArray:
    # list of list
    def __init__(self, length: int):
        self.dic = [[[-1, 0]] for i in range(length)]
        self.snapid = 0

    def set(self, index: int, val: int) -> None:
        if self.dic[index][-1][0] == self.snapid:
            self.dic[index][-1][1] = val
        else:
            self.dic[index].append([self.snapid, val])

    def snap(self) -> int:
        self.snapid += 1
        return self.snapid - 1

    def get(self, index: int, snap_id: int) -> int:
        lst = self.dic[index]
        i = bisect.bisect_left(lst, [snap_id + 1]) - 1
        return lst[i][1]


# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)