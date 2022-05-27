# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #正常的中序遍历顺序是先左子树后右子树，这里需要反过来，先右子树后左子树
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        sum = 0
        def inorder(root):
            nonlocal sum
            if not root:
                return
            inorder(root.right)
            sum += root.val
            root.val = sum
            inorder(root.left)
            
        inorder(root)
        return root