# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    curr_cnt = 1
    max_cnt = 1
    prev = None
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        lst = []
        self.inorder(root, lst)
        return lst
    def inorder(self, root, lst):
        if not root:
            return
        self.inorder(root.left, lst)
        if self.prev:
            if self.prev.val == root.val:
                self.curr_cnt +=1
            else:
                self.curr_cnt = 1
        if self.curr_cnt > self.max_cnt:
            self.max_cnt = self.curr_cnt
            lst.clear()
            lst.append(root.val)
        elif self.curr_cnt == self.max_cnt:
                lst.append(root.val)
        self.prev = root
        self.inorder(root.right, lst)
    
        
        