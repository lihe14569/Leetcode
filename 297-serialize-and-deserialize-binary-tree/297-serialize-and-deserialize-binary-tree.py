# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        serial_str = []
        def dfs(root):
            nonlocal serial_str
            if not root:
                serial_str.append('#')
                return
            serial_str.append(str(root.val))
            dfs(root.left)
            dfs(root.right)
        
        dfs(root)
        
        return ','.join(serial_str)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data: return None
        serial_str = deque(data.split(','))
        def dfs2(q):
            node = q.popleft()
            if node == '#':
                return None
            root = TreeNode(int(node))
            root.left = dfs2(q)
            root.right = dfs2(q)
            return root
        return dfs2(serial_str)

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))