# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if  not lists: return None
        
        if len(lists) == 1: return lists[0]
        m = len(lists) //2
        left, right = self.mergeKLists(lists[:m]), self.mergeKLists(lists[m:])
        def merge(list1, list2):
            if not list1: return list2
            if not list2:return list1
            dummy = curr = ListNode(0)
            while list1 and list2:
                if list1.val < list2.val:
                    curr.next = list1
                    list1 = list1.next
                else:
                    curr.next = list2
                    list2 = list2.next
                curr = curr.next
            if list1: curr.next = list1
            else: curr.next = list2
            return dummy.next
        return merge(left, right)
    
#     def merge(self, list1, list2):
#             if not list1: return list2
#             if not list2:return list1
#             dummy = curr = ListNode(0)
#             while list1 and list2:
#                 if list1.val < list2.val:
#                     curr.next = list1
#                     list1 = list1.next
#                 else:
#                     curr.next = list2
#                     list2 = list2.next
#                 curr = curr.next
#             if list1: curr.next = list1
#             else: curr.next = list2
#             return dummy.next
    