stack Time O(n)
```
public int scoreOfParentheses(String s) {
Stack<Integer> stack = new Stack<>();
int curr = 0;
for(char c : s.toCharArray()) {
if(c == '(') {
stack.push(curr);
curr = 0;
} else {
curr = stack.pop() + Math.max(curr * 2, 1);
}
}
return curr;
}
```
​
方法二： find close pair parenthesis Time O(n)  space O(1)
```
public int scoreOfParentheses(String s) {
int balance = 0;
int res = 0;
for(int i = 0; i < s.length(); i++) {
if(s.charAt(i) == '(') {
balance++;
} else {
balance--;
//determine if it is a closed pair
if(s.charAt(i - 1) == '(')
res += 1 << balance;
}
}
return res;
}
```