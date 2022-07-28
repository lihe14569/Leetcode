class Solution:
    def addBinary(self, a: str, b: str) -> str:
        carry = 0
        i, j = len(a) - 1, len(b) - 1
        res = ''
        while i >= 0 or j >= 0 or carry:
            c1 = a[i] if i >= 0 else '0'
            c2 = b[j] if j >= 0 else '0'
            curr = (int(c1) +int(c2) + carry) % 2
            res += str(curr)
            carry = (int(c1) +int(c2) + carry) // 2
            i -= 1
            j -= 1

        return res[:: -1]