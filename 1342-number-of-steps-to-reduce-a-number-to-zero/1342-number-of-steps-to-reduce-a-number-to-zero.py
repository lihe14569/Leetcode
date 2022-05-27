class Solution:
    def numberOfSteps(self, num: int) -> int:
        bits = bin(num)[2:]
        step = 0
        for b in bits:
            if b == '1':
                step += 2
            else:
                step += 1
        return step - 1