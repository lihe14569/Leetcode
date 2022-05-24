class Solution:
    def splitListToParts(self, root, k):
        cur = root
        for N in range(1001):
            if not cur: break
            cur = cur.next
        width, remainder = divmod(N, k)

        ans = []
        cur = root
        for i in range(k):
            head = cur
            jump = width - 1 + (1 if remainder > 0 else 0)
            remainder -= 1
            for j in range(jump):
                if cur: cur = cur.next
            if cur:
                next_head = cur.next
                cur.next = None
                cur = next_head
            ans.append(head)
        return ans