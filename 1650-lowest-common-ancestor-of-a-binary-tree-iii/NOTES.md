方法一：链表求intersection
```
public Node lowestCommonAncestor(Node p, Node q) {
//求链表的intersection
Node first = p, second = q;
while(first != second) {
first = first == null ? q : first.parent;
second = second == null ? p : second.parent;
}
return first;
}
```
方法二：一路向上+ set
​