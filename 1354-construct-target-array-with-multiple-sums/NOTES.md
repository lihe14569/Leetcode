​
```
public boolean isPossible(int[] target) {
if(target.length == 1) return target[0] == 1;
PriorityQueue<Integer> pq =new PriorityQueue<>((a, b) -> b - a);
int sum = 0;
for(int num : target){
pq.offer(num);
sum += num;
}
while(pq.peek() != 1) {
int largest = pq.poll();
int others = sum - largest;
if(others == 1) return true;
int prev = largest % others;
if(prev == 0 || prev == largest) return false;
pq.offer(prev);
sum = sum - largest + prev;
}
return true;
}
```