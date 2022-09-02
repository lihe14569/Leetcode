# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root: Optional[TreeNode]) -> str:
        """Encodes a tree to a single string.
        """
        if not root: return ''
        res = []
        def dfs(root):
            nonlocal res
            if not root:
                return 
            res.append(str(root.val))
            dfs(root.left)
            dfs(root.right)
        dfs(root)
        return ','.join(res)
    
    def deserialize(self, data: str) -> Optional[TreeNode]:
        """Decodes your encoded data to tree.
        """
        if not data: return None
        lst = deque(data.split(','))
        def dfs2(lst, min, max):
            val = int(lst[0])
            if val >= max or val <= min:
                return None
            root = TreeNode(lst.popleft())
            
            if lst: root.left = dfs2(lst, min, val)
            if lst: root.right = dfs2(lst, val, max)
            return root
        return dfs2(lst, -1, 10001)
# Your Codec object will be instantiated and called as such:
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# tree = ser.serialize(root)
# ans = deser.deserialize(tree)
# return ans