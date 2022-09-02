"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Codec:
    def serialize(self, root: 'Node') -> str:
        """Encodes a tree to a single string.
        
        :type root: Node
        :rtype: str
        """
        if not root: return None
        str_lst = []
        def dfs(root):
            nonlocal str_lst
            if not root:
                str_lst.append('#')
                return
            str_lst.append(str(root.val))
            str_lst.append(str(len(root.children)))
            for child in root.children:
                dfs(child)
        dfs(root)
        return ','.join(str_lst)
	
    def deserialize(self, data: str) -> 'Node':
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: Node
        """
        if not data: return None
        str_lst = deque(data.split(','))
        def dfs2(str_lst):
            val = int(str_lst.popleft())
            if val == '#':
                return None
            cnt = int(str_lst.popleft())
            root = TreeNode(val)
            root.children = []
            for i in range(cnt):
                root.children.append(dfs2(str_lst))
            return root
        return dfs2(str_lst)
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))