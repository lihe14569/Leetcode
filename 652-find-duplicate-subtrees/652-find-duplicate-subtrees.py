# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        key_id = Counter()
        res = []
        id = 0
        def dfs(root):
            if not root:
                return 'x'
            key = str(root.val) + ',' + dfs(root.left) + ',' + dfs(root.right)
            key_id[key] += 1
            
            if key_id[key] == 2:
                res.append(root)
            return key
        dfs(root)
        return res
            