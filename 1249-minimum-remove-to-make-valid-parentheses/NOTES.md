方法一： stack + stringbuilder
​
```java
public String minRemoveToMakeValid(String s) {
Set<Integer> toRemove =  new HashSet<>();//set store index to be removed
Deque<Integer> stack = new ArrayDeque<>();//维护stack平衡
for(int i = 0; i < s.length(); i++) {
if(s.charAt(i) == '(')
stack.push(i);
else if(s.charAt(i) == ')') {
if(stack.isEmpty())
toRemove.add(i);
else
stack.pop();
}
}
//注意：清空所有剩余的index,都放进tobe remove hashset里面
while(!stack.isEmpty())
toRemove.add(stack.pop());
StringBuilder sb = new StringBuilder();
for(int i = 0; i < s.length(); i++) {
if(!toRemove.contains(i)) {
sb.append(s.charAt(i));
}
}
return sb.toString();
}
```
​
方法二： stringbuilder + two pass
```
public String minRemoveToMakeValid(String s) {
StringBuilder sb = new StringBuilder();
int balance = 0;