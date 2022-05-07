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
        def dfs1(root, string):
            if root is None:
                string += 'None,'
            else:
                string += str(root.val) + ','
                string = dfs1(root.left, string)
                string = dfs1(root.right, string)
            return string
        return dfs1(root, '')

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def dfs2(lst):
            if lst[0] == 'None':
                lst.pop(0)
                return None
            root = TreeNode(lst[0])
            lst.pop(0)
            root.left = dfs2(lst)
            root.right = dfs2(lst)
            return root
        lst1 = data.split(',')
        return dfs2(lst1)
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))