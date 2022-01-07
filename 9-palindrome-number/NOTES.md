方法一： 全部取余 reverse
```
public boolean isPalindrome(int x) {
int reverse = 0, origin = x;
while(x > 0) {
reverse = reverse * 10 + x % 10;
x /= 10;
}
return reverse == origin;
}
```
​
优化：
取一半
​