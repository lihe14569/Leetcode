# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        n = len(preorder)
        preorder_map = {}
        for i, val in enumerate(preorder):
            preorder_map[val] = i
        def buildTree(prestart, preend, poststart, postend):
            nonlocal preorder_map
            if prestart > preend or poststart > postend:
                return None
            print(prestart)
            root = TreeNode(preorder[prestart])
            if(prestart == preend): return root;
            
            left_count = preorder_map[postorder[postend - 1]] - prestart - 1
            if(left_count < 0):
                left_count = 0
            root.left = buildTree(prestart + 1, prestart + left_count, poststart, poststart + left_count - 1)
            root.right = buildTree(prestart + left_count + 1, preend, poststart + left_count, postend - 1)
            return root
        return buildTree(0, n - 1, 0, n - 1)
    
            