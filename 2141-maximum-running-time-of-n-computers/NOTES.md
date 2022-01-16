binary search
```
public long maxRunTime(int n, int[] batteries) {
long sum = 0;
for(int b : batteries) sum += b;
long l  = 0, r = sum / n;
long res =  0;
while(l < r) {
//question ask maximum number
long m = (l + r + 1) / 2;
if(canFit(n, m, batteries)) {
res = m;
l = m;
} else {
r = m - 1;
}
}
return l;
}
public boolean canFit(int n, long time, int[] batt) {
long sum = 0;
long target = n * time;
for(int b : batt) {
if(b < time) {
sum += b;
} else {
sum += time;
}
if(sum >= target) return true;
}
return sum >= target;
}
```