count and say
```
public String countAndSay(int n) {
String s  = "1";
for(int i = 1; i <n ; i++) {
String temp = "";
for(int j = 0; j < s.length(); j++) {
int k = j;
while(k < s.length() && s.charAt(k) == s.charAt(j)) k++;
temp += String.valueOf(k - j) + s.charAt(j);
//注意更新j,跳回k -1,因为循环之后就还要加一
j = k - 1;
}
s = temp;
}
return s;
}
```