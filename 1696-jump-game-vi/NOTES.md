dp + arraydeque(monotonic queue)
python
```
class Solution:
def maxResult(self, nums: List[int], k: int) -> int:
n = len(nums)
score = [0] * n
score[0] = nums[0]
q = deque()
q.append(0)
for i in range(1, n):
while q and q[0] < i - k:
q.popleft()
score[i] = score[q[0]] + nums[i]
while q and score[i] >= score[q[-1]]:
q.pop()
q.append(i)
return score[-1]
```
​
java
```
class Solution {
public int maxResult(int[] nums, int k) {
int n = nums.length;
int[] score = new int[n];
score[0] = nums[0];
Deque<Integer> q = new ArrayDeque<>();
q.offerLast(0);
for(int i = 1; i < n; i++) {
//pop old element
while(!q.isEmpty() && q.peekFirst() < i - k) {
q.pollFirst();
}
score[i] = score[q.peekFirst()] + nums[i];
//maintain decreasing
while(!q.isEmpty() && score[i] >= score[q.peekLast()]) {
q.pollLast();
}
q.offerLast(i);
}
return score[n - 1];
}
}
```