my method
```
public int addDigits(int num) {
while(num >= 10) {
String s = String.valueOf(num);
int res = 0;
for(char c : s.toCharArray()) {
res += c - '0';
}
if(res < 10) {
return res;
}
num = res;
}
return num;
}
}
```
​
​