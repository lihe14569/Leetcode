class Solution:
    def largestVariance(self, s: str) -> int:
        def kadane(letter1, letter2, string):
            ans= 0
            cur1= cur2 = 0
            flag1=flag2 = True

            for i in string:
                cur1+=(i==letter1)-(i==letter2)
                flag1 &=(i!=letter2)

                cur2+=(i==letter2)-(i==letter1)
                flag2 &=(i!=letter1)

                if cur1<0: cur1, flag1 =0, True 
                if cur2<0: cur2, flag2=0, True 
                ans = max(ans, cur1-flag1, cur2-flag2)
            return ans

        ans = 0
        for a,b in combinations(set(s), 2):
            arr = [i for i in s if i==a or i==b]
            ans= max(ans, kadane(a,b,arr))
        return ans