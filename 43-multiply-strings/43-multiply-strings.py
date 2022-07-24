class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m, n = len(num1), len(num2)
        l1, l2 = [], []
        
        for i in range(m -1, -1, -1):
            l1.append(ord(num1[i]) - ord('0'))
        for i in range(n -1, -1, -1):
            l2.append(ord(num2[i]) - ord('0'))
        
        lst = [0] * (m + n)
        for i in range(m):
            for j in range(n):
                lst[i + j] += l1[i] * l2[j]
        carry = 0
        for i in range(len(lst)):
            val = carry + lst[i]
            lst[i] = val % 10
            carry = val // 10
            
        k = len(lst) - 1
        while k > 0 and lst[k] == 0:
            k -= 1
        res = ""
        while k >= 0:
            res += str(lst[k])
            k -= 1
        return res