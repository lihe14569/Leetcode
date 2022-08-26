# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        q = deque([(root, 0)])
        left = right = 0
        vertical_map = defaultdict(list)
        
        while q:
            size = len(q)
            for i in range(size):
                node, vert_idx = q.popleft()
                vertical_map[vert_idx].append(node)
                left = min(left, vert_idx)
                right = max(right, vert_idx)
                if node.left:
                    q.append((node.left, vert_idx - 1))
                if node.right:
                    q.append((node.right, vert_idx +1))
        for i in range(left, right + 1):
            lst = vertical_map[i]
            if lst:
                res.append([node.val for node in lst])
        return res
                    