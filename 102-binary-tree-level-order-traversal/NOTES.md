method1: bfs
```
if not root: return []
q, res = deque([root]),[]
while q:
level, size = [], len(q)
for i in range(size):
node = q.popleft()
level.append(node.val)
if node.left:
q.append(node.left)
if node.right:
q.append(node.right)
res.append(level)
return res
```
method2: DFS
```
​
```