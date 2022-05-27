# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        def preorder(root, sum):
            nonlocal res, dic
            if not root:
                return 
            sum += root.val
            if sum == targetSum:
                res += 1
            if sum - targetSum in dic:
                res += dic[sum - targetSum]
            dic[sum] += 1
            preorder(root.left, sum)
            preorder(root.right, sum)
            dic[sum] -= 1
        dic = defaultdict(int)
        res = 0
        preorder(root, 0)
        return res