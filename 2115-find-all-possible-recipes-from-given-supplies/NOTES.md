方法一：拓扑排序
思路与算法
​
我们把每一种原材料（菜也算一种原材料）看成图上的一个节点，如果某一道菜需要一种原材料，就添加一条从原材料到菜的有向边。
​
可以发现，如果图上的一个节点的入度为 00（即不存在以该节点为终点的边），那么该节点对应的原材料是可以直接使用的。特别地，如果该节点对应的原材料是一道菜，那么我们就可以做出这道菜。在这之后，我们将以该节点本身和以该节点为起点的边全部删除，这样就可能会有节点的入度变为 00，我们就可以不断重复这一过程，直到图中不存在节点，或所有剩余节点的入度均不为 00。
​
作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/find-all-possible-recipes-from-given-supplies/solution/cong-gei-ding-yuan-cai-liao-zhong-zhao-d-d02i/
```
class Solution:
def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
n = len(recipes)
# 图
depend = defaultdict(list)
# 入度统计
cnt = Counter()
for i in range(n):
for ing in ingredients[i]:
depend[ing].append(recipes[i])
cnt[recipes[i]] = len(ingredients[i])
ans = list()
# 把初始的原材料放入队列
q = deque(supplies)
# 拓扑排序
while q:
cur = q.popleft()
if cur in depend:
for rec in depend[cur]:
cnt[rec] -= 1
# 如果入度变为 0，说明可以做出这道菜
if cnt[rec] == 0:
ans.append(rec)
q.append(rec)
return ans
​
​
作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/find-all-possible-recipes-from-given-supplies/solution/cong-gei-ding-yuan-cai-liao-zhong-zhao-d-d02i/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```