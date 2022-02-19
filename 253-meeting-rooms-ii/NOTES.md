sweep line with extra two array, starttime and end time
```
//sweep line
int n = intervals.length;
int[] start = new int[n];
int[] end = new int[n];
for(int i = 0; i < n; i++) {
start[i] = intervals[i][0];
end[i] = intervals[i][1];
}
Arrays.sort(start);
Arrays.sort(end);
int cnt = 0, res = 0;
int si = 0, ei = 0;
while(si < n) {
if(start[si] < end[ei]) {
cnt++;
si++;
res = Math.max(res, cnt);
} else {
cnt--;
ei++;
}
}
return res;
}
```