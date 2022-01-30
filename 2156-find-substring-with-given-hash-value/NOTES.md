rabin-karp(rolling hash) + sliding window
```
public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
int len = s.length();
//注意：weight (p^(k - 1))要用long放置overflow
long weight = 1;
for(int i = 0; i < k -1 ; i++) {
weight = (weight * power) % modulo;
}
int r = len - 1;
//注意：window hashvalue 用long放置overflow
long hash = 0;
String res = "";
for(int i = len - 1; i >= 0; i--) {
int val = s.charAt(i) - 'a' + 1;
hash = (hash * power % modulo + val) % modulo;
if(r - i + 1 == k) {
if(hash == hashValue) {
res = s.substring(i, r + 1);
}
//remove head
//注意：额外加一个modulo放置减去head之后为负数
hash = (hash + modulo - (s.charAt(r--) - 'a' + 1) * weight % modulo) % modulo;
}
}
return res;
}
```
​