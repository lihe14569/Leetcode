​
```
public int longestValidParentheses(String s) {
//two pass
//first pass from left to right
int left = 0, right = 0;
int res = 0;
for(int i = 0; i < s.length(); i++) {
if(s.charAt(i) == '(') left++;
else right++;
if(left == right) {
res = Math.max(res, left + right);
} else if(left < right) {
left = 0;
right = 0;
}
}
right = 0;
left = 0;
for(int i = s.length() - 1; i >=0; i--) {
if(s.charAt(i) == ')') right++;
else left++;
if(right == left) res = Math.max(res, right + left);
else if(right < left) {
right = 0;
left = 0;
}
}
return res;
}
```