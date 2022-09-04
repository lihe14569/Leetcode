# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        map = {}
        for i, v in enumerate(inorder):
            map[v] = i
        n = len(preorder)
        print(n)
        def dfs(pstart, pend, istart, iend):
            if pstart > pend:
                return None
            root = TreeNode(preorder[pstart])
            root_index = map[preorder[pstart]]
            left_cnt = root_index - istart
            root.left = dfs(pstart + 1, pstart + left_cnt, istart, root_index - 1)
            root.right = dfs(pstart + left_cnt + 1, pend, root_index + 1, iend)
            return root
        return dfs(0, n - 1, 0, n - 1)
    