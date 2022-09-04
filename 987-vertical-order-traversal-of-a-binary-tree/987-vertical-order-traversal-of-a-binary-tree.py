# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        vertical = defaultdict(list)
        left, right = 0, 0
        q = deque([(root, 0)])
        while q:
            size = len(q)
            dict = defaultdict(list)
            for i in range(size):
                node, vert = q.popleft()
                dict[vert].append(node.val)
                if node.left:
                    q.append((node.left, vert - 1))
                    left = min(left, vert - 1)
                if node.right:
                    q.append((node.right, vert + 1))
                    right = max(right, vert + 1)
            for k, v in dict.items():
                v.sort()
                for num in v:
                    vertical[k].append(num)
            
        res = []
        for i in range(left , right + 1):
            if i in vertical:
                res.append(vertical[i])
        
        return res
        