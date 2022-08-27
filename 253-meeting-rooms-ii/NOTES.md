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
​
PriorityQueue
```
class Solution {
public int minMeetingRooms(int[][] intervals) {
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
PriorityQueue<Integer> pq = new PriorityQueue<>(); //pq利表示的是进行的会议的结束时间
int cnt = 0;
for(int[] i :intervals) {
while(!pq.isEmpty() && pq.peek() <= i[0]) //使用中最早的房子早于当前会议开始时间
pq.poll(); //pq中的最早结束会议室腾空了
pq.offer(i[1]); //将当前的会议安排上
cnt = Math.max(cnt, pq.size()); //更新现在正在进行的会议数量
}
return cnt;
}
}
```
​
扫描线start time  和 end time合并成一个list, start + 1， end - 1,sort by time
```
class Solution:
def minMeetingRooms(self, intervals: List[List[int]]) -> int:
time = []
for interval in intervals:
time.append((interval[0], 1))
time.append((interval[1], -1))
time.sort(key = lambda x : (x[0], x[1]))
cnt = 0
res = 0
for t in time:
cnt += t[1]
res = max(res, cnt)
return res
```