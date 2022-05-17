class Solution:
    def maximumEvenSplit(self, finalSum: int) -> List[int]:
        res = []
        if finalSum % 2 != 0:
            return res
        even = 2
        while finalSum >= even:
            finalSum -= even
            res.append(even)
            even += 2
        if finalSum > 0:
            last = res.pop() + finalSum
            res.append(last)
           
        return res
            