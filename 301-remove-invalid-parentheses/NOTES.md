backtrack (no pruning)
​
```
public List<String> removeInvalidParentheses(String s) {
int rmL = 0, rmR= 0;
int n = s.length();
for(int i = 0; i < n; i++) {
if(s.charAt(i) == '(')
rmL++;
else if(s.charAt(i) == ')') {
if(rmL > 0) rmL--;
else rmR++;
}
}
Set<String> res = new HashSet<>();
helper(s, res, 0, rmL, rmR, 0, new StringBuilder());
return new ArrayList<>(res);
}
public void helper(String s, Set<String> res, int i, int rmL, int rmR, int open, StringBuilder sb) {
//base case
if(rmL  < 0 || rmR < 0 || open < 0 || i > s.length()) return;
if(i == s.length()) {
if(rmL == 0 && rmR == 0 && open == 0) {
res.add(sb.toString());
}
return;//不管是不是答案，都要return，因为已经遍历完了
}
int len = sb.length();
char c = s.charAt(i);
if(c == '(') {
helper(s, res, i + 1, rmL - 1, rmR, open, sb); //not use this parentheses
helper(s, res, i + 1, rmL, rmR, open + 1, sb.append(c)); //use this parentheses
} else if(c == ')') {
helper(s, res, i + 1, rmL, rmR - 1, open, sb); //not use this parentheses
helper(s, res, i + 1, rmL, rmR, open - 1, sb.append(c)); // use this parentheses
} else {
helper(s, res, i + 1, rmL, rmR, open, sb.append(c));
}
sb.setLength(len);
}
```
​
backtracking 优化版本
```
public List<String> removeInvalidParentheses(String s) {
int rmL = 0, rmR = 0;
List<String> res = new ArrayList<>();