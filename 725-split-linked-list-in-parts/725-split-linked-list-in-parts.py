# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        cur = head
        cnt = 0
        while cur:
            cnt += 1
            cur = cur.next
        width, remainder = divmod(cnt, k)
        res = []
        curr = head
        for i in range(k):
            head = curr
            jump = width - 1 + (1 if remainder > 0 else 0)
            remainder -= 1
            for j in range(jump):
                if curr:
                    curr = curr.next
            if curr:
                next_head = curr.next
                curr.next = None
                curr = next_head
            res.append(head)
        return res
            