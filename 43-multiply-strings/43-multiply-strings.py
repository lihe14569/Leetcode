class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m, n = len(num1), len(num2)
        l1, l2 = [], []
        for i in range(len(num1) -1, -1, -1):
            l1.append(ord(num1[i]) - ord('0'))
        for i in range(len(num2) -1, -1, -1):
            l2.append(ord(num2[i]) - ord('0'))
        
        res=[0] * (m + n)
        
        for i in range(m):
            for j in range(n):
                print(i)
                print(j)
                
                res[i + j] += l1[i] * l2[j]
        
        carry = 0
        for i in range(len(res)):
            val = carry + res[i]
            res[i] = val % 10
            carry = val // 10
        
        k = len(res) - 1
        while k > 0 and res[k] == 0: k -= 1
        
        s = ""
        
        while k >= 0:
            s += str(res[k])
            k -= 1
        return s