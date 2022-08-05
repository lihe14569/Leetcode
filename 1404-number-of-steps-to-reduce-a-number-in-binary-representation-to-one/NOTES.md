方法一： 把string编程integer, 然后按integer 算
limit: string 长500， 不能转换成number
```
public int numSteps(String s) {
int num = 0;
for(int i = s.length() - 1; i >= 0; i--) {
if(s.charAt(i) == '1')
num |= 1 << (s.length() - 1 - i);
}
System.out.println(num);
int cnt = 0;
while(num != 1) {
if(num % 2 == 1) num++;
else num /= 2;
cnt++;
}
return cnt;
}
```