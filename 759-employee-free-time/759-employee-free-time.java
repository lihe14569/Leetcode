/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.start, b.start));
        for(List<Interval> l : schedule) {
            for(Interval interv : l) {
                pq.offer(interv);
            }
        }
        Interval curr = pq.poll();
        while(!pq.isEmpty()) {
            if(curr.end >= pq.peek().start) {
                curr.end = Math.max(curr.end, pq.poll().end);
            } else {
                res.add(new Interval(curr.end, pq.peek().start));
                curr = pq.poll();
            }
        }
        return res;
    }
}