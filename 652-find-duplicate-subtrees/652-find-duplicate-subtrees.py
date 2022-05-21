# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        tree_freq = Counter()
        res = []
        def dfs(root):
            #base case
            if not root:
                return '#'
            key = ','.join([str(root.val), dfs(root.left), dfs(root.right)])
            if key in tree_freq:
                tree_freq[key] += 1
                if tree_freq[key] == 2:
                    res.append(root)
            else:
                tree_freq[key] = 1
            return key
        dfs(root)
        return res